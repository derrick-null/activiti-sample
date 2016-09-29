package com.cccis.activiti.listener;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class TaskListener2  implements TaskListener{
	
	private static final long serialVersionUID = -3449184060970641654L;
	@Override
	public void notify(DelegateTask arg0) {
		System.out.println("Task "+ arg0.getName() + " complete is running");
		
	}
}
