package com.vtkrishn.spring;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;

public class Triangle implements ApplicationContextAware, BeanNameAware,InitializingBean, DisposableBean, ApplicationEventPublisherAware{
	
	private String type;
	private int height;
	
	private Point pointA;
	private Point pointB;
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	private Point pointC;
	
	private List<Point> points;
	private ApplicationContext applicationContext;
	
	MessageSource messageSource;
	ApplicationEventPublisher applicationEventPublisher;
	
	public MessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	@Autowired
	@Qualifier("circleRelated")
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	public Triangle() {
		
	}
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Triangle(String type) {
		this.type = type;
	}
	
	public Triangle(int height) {
		this.height = height;
	}
	
	public Triangle(String type,int height) {
		this.type = type;
		this.height = height;
	}
	
	public void draw() {
		System.out.println(this.type + " Triangle is drawn " + this.height);
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void getPoints() {
		System.out.println(pointA.getX() + " " + pointA.getY());
		System.out.println(pointB.getX() + " " + pointB.getY());
		System.out.println(pointC.getX() + " " + pointC.getY());
	}
	
	public void getListPoints() {
		for(Point point : points) {
			System.out.println(point.getX() + " " + point.getY());
		}
		System.out.println("message ----> "+this.messageSource.getMessage("pointA.pointX", null,"nothing",null));
		DrawEvent d = new DrawEvent(this);
		applicationEventPublisher.publishEvent(d);
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.applicationContext = arg0;		
	}
	@Override
	public void setBeanName(String arg0) {
		System.out.println(arg0);
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init method call for triangle implements");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy method call for triangle implements");
		
	}
	
	@PostConstruct
	public void myInit() {
		System.out.println("Init method");
	}
	
	@PreDestroy
	public void myDestroy() {
		System.out.println("Destroy method");
	}
	
	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		this.applicationEventPublisher = arg0;
	}
	
}
