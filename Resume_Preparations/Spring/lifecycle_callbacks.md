To release the context
context.shutdownRegisterHook(); - AbstractApplicationContext
//((ClassPathXmlApplicationContext) context).close();

Intiializing & Destroying
---------------
implements InitializingBean
implements DisposableBean
@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init method call for triangle");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy method call for triangle");

	}

you can do it in beans
----------------------
<bean id="triangle" class="com.vtkrishn.spring.Triangle" parent="parentTriangle" init-method="myInit" destroy-method="myDestroy">

public void myInit() {
		System.out.println("Init method");
	}

	public void myDestroy() {
		System.out.println("Destroy method");
	}
	--------
  do init and destroy at global level

  <beans xmlns="http://www.springframework.org/schema/beans"
    default-init-method="myInit" default-destroy-method="myDestroy">

InitializingBean and DisposableBean takes priority if you have both options

-----------------
BeanPostProcessors
common class to have initialization for each of the beans
public class DisplayNameBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("After init "+beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("before init "+beanName);
		return bean;
	}
}
<bean class="com.vtkrishn.spring.DisplayNameBeanPostProcessor"/>
-----------
BeanFactoryPostProcessor
define properties and refer in the value section of the bean properties
PropertyPlaceholderConfigurer

<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
<property name="locations" value="prop.properties"/>
</bean>

<bean id="point0" class="com.vtkrishn.spring.Point" scope="singleton" >
<property name="x" value="${pointA.pointX}" />
<property name="y" value="${pointA.pointY}" />
</bean>
