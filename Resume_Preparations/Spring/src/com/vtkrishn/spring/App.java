package com.vtkrishn.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		//Triangle triangle = new Triangle();
		
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//ApplicationContext context = new ClassPathXmlApplicationContext("file:src/com/vtkrishn/spring/spring.xml");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("file:src/com/vtkrishn/spring/spring.xml");
		//Triangle triangle = (Triangle)context.getBean("triangle");
		Triangle triangle = (Triangle)context.getBean("triangleAlias");
		//triangle.draw();
		//triangle.getPoints();
		//triangle.getListPoints();
		//((ClassPathXmlApplicationContext) context).close();
		System.out.println("message ----> "+context.getMessage("pointA.pointX", null,"nothing",null));
		context.registerShutdownHook();
		
	}
	
}
