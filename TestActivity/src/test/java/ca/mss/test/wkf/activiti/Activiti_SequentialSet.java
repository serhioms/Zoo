package ca.mss.test.wkf.activiti;

import org.junit.Rule;
import org.junit.Test;

import ca.mss.impl.wkf.activiti.ActivityHelper;
import ca.rdmss.multitest.annotation.MultiBefore;
import ca.rdmss.multitest.annotation.MultiTest;
import ca.rdmss.multitest.annotation.MultiThread;
import ca.rdmss.multitest.junitrule.MultiTestRule;

@MultiTest(repeatNo=ActivitiSuite.MAX_TRY )
public class Activiti_SequentialSet {
	
	@Rule
	public MultiTestRule rule = new MultiTestRule(this);

	ActivityHelper act, act2;
	
	@MultiBefore
	public void setUp() throws Exception {
		act = new ActivityHelper();
		act.addWorkflowPath("diagrams/SequentialSet.bpmn");

		act2 = new ActivityHelper();
		act2.addWorkflowPath("diagrams/SequentialSet2.bpmn");
	}

	@MultiThread
	public void oneThread() throws InterruptedException{
		act.startWorkflow("mySequentialProcess");
		Thread.sleep(100l); // let flow finish before start new one
	}
	
	@MultiThread
	public void secondThread() throws InterruptedException{
		act2.startWorkflow("mySequentialProcess2");
		Thread.sleep(100l);// let flow finish before start new one
	}
	
	@Test
	public void test() throws InstantiationException, IllegalAccessException, InterruptedException {
		System.out.println( rule.getResult() );
		System.out.println( ReportTask.test.results );
		System.out.println( ReportTask2.test.results );
	}

}
