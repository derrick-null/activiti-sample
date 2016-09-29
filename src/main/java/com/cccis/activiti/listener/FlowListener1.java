package com.cccis.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class FlowListener1 implements ExecutionListener{

	private static final long serialVersionUID = -7999010235932996920L;

	@Override
	public void notify(DelegateExecution paramDelegateExecution) throws Exception {
		System.out.println("FlowListener1 is running");
	}
}
