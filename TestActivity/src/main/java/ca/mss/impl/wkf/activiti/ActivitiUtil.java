package ca.mss.impl.wkf.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.DeploymentBuilder;

public class ActivitiUtil {

	public static void startWorkflow(String wkfPath, String wksProcess) throws InterruptedException {

		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		
		// Deploy flow
		RepositoryService repositoryService = processEngine.getRepositoryService();
		
		DeploymentBuilder createDeployment = repositoryService.createDeployment();
		createDeployment.addClasspathResource(wkfPath);
		
		createDeployment.deploy();
		
		// Run flow
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		System.out.println(wkfPath);

		runtimeService.startProcessInstanceByKey(wksProcess);
		
		System.exit(0);
	
	}

}
