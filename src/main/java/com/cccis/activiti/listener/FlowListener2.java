package com.cccis.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class FlowListener2 implements ExecutionListener{
	
	private static final long serialVersionUID = -1988461231261632586L;

	@Override
	public void notify(DelegateExecution arg0) throws Exception {
		System.out.println("FlowListener2 is running");
	}
}
