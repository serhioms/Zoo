package ca.mss.test.wkf.activiti;

import java.util.concurrent.atomic.AtomicInteger;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class TestTask implements JavaDelegate {

	static public AtomicInteger counter = new AtomicInteger(0);
	static public String result = "";

	static public void initialize(){
		counter.set(0);
		result = "";
	}
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {

		int cnt = counter.incrementAndGet();

		if( cnt %3 == 0 ){
			 // Let's allow synch task #4 run faster then async task #3
			Thread.sleep(15l);
			Thread.yield();
		}

		result += (String.format("Task #%d;", cnt));
	}

}
