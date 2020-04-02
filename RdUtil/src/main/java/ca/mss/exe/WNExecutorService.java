package ca.mss.exe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class WNExecutorService implements ExecutorService {

	private static final String NOT_IMPLEMENTED = "Not Implemented!";
	
	private final List<Runnable> todo = new ArrayList<Runnable>();
	
	private final Consumer<Runnable> wait;
	private final Consumer<Exception> errorHandler;
	
	private final AtomicInteger count = new AtomicInteger(); 

	public WNExecutorService() {
		this(r->{}, e->e.printStackTrace()); 
	}
	
	public WNExecutorService(Consumer<Runnable> wait) {
		this(wait, e->e.printStackTrace());
	}
	
	public WNExecutorService(Consumer<Runnable> wait, Consumer<Exception> errorHandler) {
		this.wait = wait;
		this.errorHandler = errorHandler;
	}

	public void clean() {
		todo.clear();
	}

	@Override
	synchronized public void execute(Runnable command) {
		todo.add(command);
	}

	synchronized public void start(boolean isParallel) {
		if( !todo.isEmpty() ){
			count.set(isParallel?todo.size(): 0);
			todo.stream().forEach(run->{
				try {
					Thread thread = new Thread(()->{
						try {
							if( isParallel ){
								synchronized( todo ){
									wait.accept(run);
									count.decrementAndGet();
									todo.wait();
								}
							}
							run.run();
						} catch (Exception e) {
							errorHandler.accept(e);
						} finally {
							count.incrementAndGet();
						}
					});
					thread.start();
					if( !isParallel){
						thread.join();
					}
				} catch (Exception e) {
					errorHandler.accept(e);
				}
			});
			if( isParallel ){
				try {
					while( count.get() > 0 ) TimeUnit.NANOSECONDS.sleep(1); /* wait for all threads run */
					synchronized( todo ){
						todo.notifyAll();
					}
				} catch (Exception e) {
					errorHandler.accept(e);
				}
			}
		}
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		if( count.get() != todo.size() ){
			 unit.sleep(timeout);
		}
		return count.get() == todo.size();
	}

	
	@Override
	public void shutdown() {
		this.start(true);
	}

	@Override
	public List<Runnable> shutdownNow() {
		return todo;
	}

	@Override
	public boolean isShutdown() {
		return true;
	}

	@Override
	public boolean isTerminated() {
		return false;
	}

	@Override
	public <T> Future<T> submit(Callable<T> task) {
		throw new RuntimeException(NOT_IMPLEMENTED);
	}

	@Override
	public <T> Future<T> submit(Runnable task, T result) {
		throw new RuntimeException(NOT_IMPLEMENTED);
	}

	@Override
	public Future<?> submit(Runnable task) {
		throw new RuntimeException(NOT_IMPLEMENTED);
	}

	@Override
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
		throw new RuntimeException(NOT_IMPLEMENTED);
	}

	@Override
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException {
		throw new RuntimeException(NOT_IMPLEMENTED);
	}

	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
		throw new RuntimeException(NOT_IMPLEMENTED);
	}

	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException, ExecutionException, TimeoutException {
		throw new RuntimeException(NOT_IMPLEMENTED);
	}
}
