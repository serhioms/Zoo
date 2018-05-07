package ca.mss.impl.wkf.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.DeploymentBuilder;

public class ActivityHelper {

	final ProcessEngine processEngine;
	final RepositoryService repositoryService;
	final DeploymentBuilder createDeployment;
	final RuntimeService runtimeService;
	
	public ActivityHelper() {

		processEngine = ProcessEngines.getDefaultProcessEngine();
		
		// Deploy flow
		repositoryService = processEngine.getRepositoryService();
		
		createDeployment = repositoryService.createDeployment();
		//createDeployment.addClasspathResource(wkfPath);
		//createDeployment.deploy();
		
		// Run flow
		runtimeService = processEngine.getRuntimeService();
		
		//runtimeService.startProcessInstanceByKey(wkfProcess);
	}
	
	public void addWorkflowPath(String wkfPath){
		createDeployment.addClasspathResource(wkfPath);
		createDeployment.deploy();
	}

	public void startWorkflow(String wkfProcess){
		runtimeService.startProcessInstanceByKey(wkfProcess);
	}

}
