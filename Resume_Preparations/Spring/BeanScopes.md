By Default all beans are singleton
Singleton - for the spring Container
prototype - new object for each of the request or reference (for every ref of object, for getBean)

Request - New bean per requests
Session - New bean per Session
Global Session - New bean per global http session (portlet)


ApplicationContextAware
---------------------------
to use the application context in the bean

public class Triangle implements ApplicationContextAware{
  @Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.applicationContext = arg0;		
	}
BeanAware
-------------
override - setBeanName()

Bean definition inheritance
------------------------------
parent option in bean
<bean id="parentTriangle" class="com.vtkrishn.spring.Triangle">
	<property name="pointA" ref ="point0"/>
</bean>

<bean id="triangle" class="com.vtkrishn.spring.Triangle" parent="parentTriangle">

------------
collection parent if you define the same list property in child you can merge the collection
<list merge="true">
<ref bean="point0">
</list>
-----------------
