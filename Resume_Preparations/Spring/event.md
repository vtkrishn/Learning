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


------------

@Component
public class myListener implements ApplicationListener{

  	<bean class="com.vtkrishn.spring.myListener" />

own Custom Event
    public class DrawEvent extends ApplicationEvent{

    from the bean publish using   
    ApplicationEventPublisher

implement ApplicationEventPublisherAware class and set the publisher
applicationEventPublisher.publishEvent(d);
