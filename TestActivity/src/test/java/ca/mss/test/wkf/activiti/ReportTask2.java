package ca.mss.test.wkf.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ReportTask2 implements JavaDelegate {

	static public ca.rdmss.util.TestHelper test = new ca.rdmss.util.TestHelper();

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		// Wait for task #3 ends
		Thread.sleep(20l);
		
		test.count(TestTask.result);

		TestTask.initialize();
	}
}
