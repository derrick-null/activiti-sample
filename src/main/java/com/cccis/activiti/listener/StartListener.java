package com.cccis.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class StartListener  implements ExecutionListener{
	
	private static final long serialVersionUID = -3449184060970641654L;

	@Override
	public void notify(DelegateExecution arg0) throws Exception {
		System.out.println("StartListener is running");
	}
}
