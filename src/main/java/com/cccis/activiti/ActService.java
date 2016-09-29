package com.cccis.activiti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.TaskService;

public class ActService {

	public static void main(String[] args) {
		normalPro();
		exclusiveGateWayPro();
		parallelGateWayPro();
		inclusiveGateWayPro();
		eventGateWayPro();
	}
	/**
	 * 普通网关流程
	 * */
	public static void normalPro(){
		// 获取工作流引擎
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 获取仓库Service
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 通过仓库Service发布流程
		repositoryService.createDeployment().addClasspathResource("diagrams/normal.bpmn20.xml").deploy();
		// 流程变量
		Map<String, Object> variables = new HashMap<String, Object>();
		// 获取运行时Service
		RuntimeService runtimeService = processEngine.getRuntimeService();
		// 启动一个流程
		runtimeService.startProcessInstanceByKey("myProcess", variables);
		// 获取TaskService
		TaskService taskService = processEngine.getTaskService();
		// 获取任务
		Task task1 = taskService.createTaskQuery().taskDefinitionKey("usertask1").singleResult();
		// 完成一个任务
		taskService.complete(task1.getId());
		Task task2 = taskService.createTaskQuery().taskDefinitionKey("usertask2").singleResult();
		taskService.complete(task2.getId());
	}

	/**
	 * 排他网关流程
	 * */
	public static void exclusiveGateWayPro(){
		// 获取工作流引擎
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 获取仓库Service
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 通过仓库Service发布流程
		repositoryService.createDeployment().addClasspathResource("diagrams/exclusive.bpmn20.xml").deploy();
		// 流程变量
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("step", 2);
		// 获取运行时Service
		RuntimeService runtimeService = processEngine.getRuntimeService();
		// 启动一个流程
		runtimeService.startProcessInstanceByKey("myProcess", variables);
		// 获取TaskService
		TaskService taskService = processEngine.getTaskService();
		// 获取任务
		Task task = taskService.createTaskQuery().taskDefinitionKey("usertask2").singleResult();
		// 完成一个任务
		taskService.complete(task.getId());
	}
	
	/**
	 * 包含网关流程
	 * */
	public static void inclusiveGateWayPro(){
		// 获取工作流引擎
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 获取仓库Service
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 通过仓库Service发布流程
		repositoryService.createDeployment().addClasspathResource("diagrams/inclusive.bpmn20.xml").deploy();
		// 流程变量
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("step", 2);
		variables.put("goToTask3", true);
		// 获取运行时Service
		RuntimeService runtimeService = processEngine.getRuntimeService();
		// 启动一个流程
		runtimeService.startProcessInstanceByKey("myProcess", variables);
		// 获取TaskService
		TaskService taskService = processEngine.getTaskService();
		// 获取任务
		Task task2 = taskService.createTaskQuery().taskDefinitionKey("usertask2").singleResult();
		// 完成一个任务
		taskService.complete(task2.getId());
		// 获取任务
		Task task3 = taskService.createTaskQuery().taskDefinitionKey("usertask3").singleResult();
		// 完成一个任务
		taskService.complete(task3.getId());
	}
	
	/**
	 * 并行网关流程
	 * */
	public static void parallelGateWayPro(){
		// 获取工作流引擎
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 获取仓库Service
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 通过仓库Service发布流程
		repositoryService.createDeployment().addClasspathResource("diagrams/parallel.bpmn20.xml").deploy();
		// 流程变量
		Map<String, Object> variables = new HashMap<String, Object>();
		// 获取运行时Service
		RuntimeService runtimeService = processEngine.getRuntimeService();
		// 启动一个流程
		runtimeService.startProcessInstanceByKey("myProcess", variables);
		// 获取TaskService
		TaskService taskService = processEngine.getTaskService();
		// 获取任务
		Task task1 = taskService.createTaskQuery().taskDefinitionKey("usertask1").singleResult();
		// 完成一个任务
		taskService.complete(task1.getId());
		// 获取任务
		Task task2 = taskService.createTaskQuery().taskDefinitionKey("usertask2").singleResult();
		// 完成一个任务
		taskService.complete(task2.getId());
	}
	
	/**
	 * 事件网关流程
	 * */
	public static void eventGateWayPro(){
		// 获取工作流引擎
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 获取仓库Service
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 通过仓库Service发布流程
		repositoryService.createDeployment().addClasspathResource("diagrams/eventbase.bpmn20.xml").deploy();
		// 流程变量
		Map<String, Object> variables = new HashMap<String, Object>();
		// 获取运行时Service
		RuntimeService runtimeService = processEngine.getRuntimeService();
		// 启动一个流程
		runtimeService.startProcessInstanceByKey("myProcess", variables);
		List<Execution> executions = runtimeService
			      .createExecutionQuery().signalEventSubscriptionName("offworkSignal")
			      .list();
		runtimeService.signalEventReceived("offworkSignal",executions.get(0).getId());
		
		// 获取TaskService
		TaskService taskService = processEngine.getTaskService();
		// 获取任务
		Task task1 = taskService.createTaskQuery().taskDefinitionKey("usertask1").singleResult();
		// 完成一个任务
		taskService.complete(task1.getId());
	}
}
