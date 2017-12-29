messageSource


<bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource" autowire="default">
<property name="basenames">
<list>
<value>prop</value>
</list></property>
</bean>

System.out.println("message ----> "+context.getMessage("pointA.pointX", null,"nothing",null));


Bean - Triangle
-----------------------
MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
System.out.println("message ----> "+this.messageSource.getMessage("pointA.pointX", null,"nothing",null));
