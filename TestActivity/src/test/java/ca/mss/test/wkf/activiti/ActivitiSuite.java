package ca.mss.test.wkf.activiti;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	Activiti_SequentialSet.class
})
public class ActivitiSuite {
	
	final public static int MAX_TRY = 100; 

}
