package com.cccis.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class EndListener implements ExecutionListener{

	private static final long serialVersionUID = 8562509230641124156L;

	@Override
	public void notify(DelegateExecution paramDelegateExecution) throws Exception {
		System.out.println("EndListener is running");
	}
}
