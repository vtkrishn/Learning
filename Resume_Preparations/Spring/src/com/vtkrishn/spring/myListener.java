package com.vtkrishn.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class myListener implements ApplicationListener{

	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		System.out.println("Application Event :"+arg0.toString());
		
	}

}
