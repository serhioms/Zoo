package my.logger;

import java.io.PrintStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


public enum Logger {
	VERBOSE(false), 
	DEBUG(false), 
	INFO(false),
	IMPORTANT(false),
	WARNING(false),
	ERROR(true),
	TEST(false);

	public boolean isOn;

	private Logger() {
		this.isOn = true;
	}

	private Logger(boolean isOn) {
		this.isOn = isOn;
	}

	public final void print(Throwable t, String s, Object... args) {
		if( isOn ){
			String msg = String.format("%10s: ",this.name()) + String.format(s, args);
			if( isThreaded ){
				put(msg);
			} else {
				println(msg, isRed()? System.err: System.out);
				t.printStackTrace(isRed()? System.err: System.out);
			}
		}
	}
	
	public final void print(Throwable t) {
		if( isOn ){
			String msg = String.format("%10s: ", this.name())+t.getMessage();
			if( isThreaded ){
				put(msg);
			} else {
				println(msg, isRed()? System.err: System.out);
				t.printStackTrace(isRed()? System.err: System.out);
			}
		}
	}
	
	public final void print(Throwable t, String s) {
		if( isOn ){
			String msg = String.format("%10s: ", this.name())+s+" due to "+t.getMessage();
			if( isThreaded ){
				put(msg);
			} else {
				println(msg, isRed()? System.err: System.out);
				t.printStackTrace(isRed()? System.err: System.out);
			}
		}
	}
	
	public final void print(String s, Object... args) {
		if( isOn ){
			String msg = String.format("%10s: ", this.name())+String.format(s, args);
			if( isThreaded )
				put(msg);
			else
				println(msg, isRed()? System.err: System.out);
		}
	}
	
	public final void print(String s) {
		if( isOn ){
			String msg = String.format("%10s: ", this.name())+s;
			if( isThreaded )
				put(msg);
			else
				println(msg, isRed()? System.err: System.out);
		}
	}

	private final boolean isRed(){
		return this == ERROR || this == TEST;
	}
	
	/*
	 * Threading logging out interface
	 */

	static public int LOGGER_MAX_MESSAGE_QUEUE_SIZE = 1000;
	static public int LOGGER_MAX_EXECUTORS = 0;

	static private String LOGGER_STOP_SIGN = "*&@!)@*$^@!*^!&)()$*%#*&";
	
	static private boolean isThreaded = false;
	static private BlockingQueue<String> msgQueue;
	static private ExecutorService executors;
	
	static {
		if( LOGGER_MAX_EXECUTORS > 0 ){
			msgQueue = new LinkedBlockingQueue<String>(LOGGER_MAX_MESSAGE_QUEUE_SIZE);
			executors = Executors.newFixedThreadPool(LOGGER_MAX_EXECUTORS);
			startup();
		}
	}

	static private void startup() {
		if( LOGGER_MAX_EXECUTORS > 0 ){
			for(int s=1; s <= LOGGER_MAX_EXECUTORS; s++){
				Thread logger = new Thread() {
					@Override
					public void run() {
						String msg = "";
						try {
							while( true ){
								msg = msgQueue.take();
								if( LOGGER_STOP_SIGN.equals(msg) )
									break;
								println(msg);
							}
							flush();
						} catch (Throwable t) {
							shutdown();
							System.err.println("Failed getting message from queue ["+msg+"]");
							t.printStackTrace(System.err);
						}
					}
				};
				
				logger.setDaemon(false);
				executors.execute(logger);
				isThreaded = true;
			}
			
			put("Logger started");
		}
	}

	synchronized static public void shutdown() {
		if( LOGGER_MAX_EXECUTORS > 0 ){
			Thread loggerShutdowner = new Thread("loggerShutdowner") {
				@Override
				public void run() {
					put("Logger shutdowned");
					for(int s=1; s <= LOGGER_MAX_EXECUTORS; s++){
						put(LOGGER_STOP_SIGN);
					}
					executors.shutdown();
				}
			};
			loggerShutdowner.setDaemon(false);
			loggerShutdowner.start();
		}
	}


	static private void put(String msg) {
		try {
			msgQueue.put(msg);
		} catch (Throwable t) {
			shutdown();
			System.err.println("Failed putting message to queue ["+msg+"]");
			t.printStackTrace(System.err);
		}
	}

	static private void println(String msg) {
		System.out.println(msg);
	}

	static private void println(String msg, PrintStream ps) {
		ps.println(msg);
	}

	static public void flush() {
		System.out.flush();
		System.err.flush();
	}

}