package com.cccis.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class FlowListener3 implements ExecutionListener{
	
	private static final long serialVersionUID = 6130895875676839737L;

	@Override
	public void notify(DelegateExecution arg0) throws Exception {
		System.out.println("FlowListener3 is running");
	}
}
