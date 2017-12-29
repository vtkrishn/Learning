https://docs.spring.io/spring/docs/5.0.x/spring-framework-reference/
https://repo.spring.io/release/org/springframework/spring/5.0.2.RELEASE/
Dependency injection
  inversion of control
Spring Bean
Spring Container
Factory Pattern
Aspect Oriented Programming(AOP)


BeanFactory
XmlBeanFactory
FileSystemResource
ApplicationContext
ClassPathXmlApplicationContext

App.java
------------
ApplicationContext context = new ClassPathXmlApplicationContext("file:src/com/vtkrishn/spring/spring.xml");
Triangle triangle = (Triangle)context.getBean("triangle");
triangle.draw();


Triangle.java
----------------
package com.vtkrishn.spring;

public class Triangle {
	private String type;

	public Triangle(String type) {
		this.type = type;
	}

	public void draw() {
		System.out.println(this.type + " Triangle is drawn");
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}


spring.xml
--------------
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">
<bean id="triangle" class="com.vtkrishn.spring.Triangle">
<property name="type" value="Equilateral" />
</bean>

Setter injection - from property name from spring.xml file
<property name="type" value="Equilateral" />

Constructor injection - from property from spring.xml file
<constructor-arg value="Dumeel" />

setting multiple values
<constructor-arg value="Dumeel" />
<constructor-arg value="20" />

setting with index and type
<constructor-arg value="20" type="int" index="0"/>

constructor index - index ="0"
ref - used to reference other beans
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN"
"http://www.springframework.org/dtd/spring-beans.dtd">
<beans>
<bean id="triangle" class="com.vtkrishn.spring.Triangle">
<property name="pointA" ref="point0" />
<property name="pointB" ref="point1" />
<property name="pointC" ref="point2" />
</bean>

<bean id="point0" class="com.vtkrishn.spring.Point">
<property name="x" value="0" />
<property name="y" value="0" />
</bean>

<bean id="point1" class="com.vtkrishn.spring.Point">
<property name="x" value="-20" />
<property name="y" value="0" />
</bean>

<bean id="point2" class="com.vtkrishn.spring.Point">
<property name="x" value="20" />
<property name="y" value="0" />
</bean>

</beans>
-------------
inner bean

<property name="pointB">
<bean class="com.vtkrishn.spring.Point">
<property name="x" value="-20" />
<property name="y" value="0" />
</bean>
</property>
<property name="pointC">
<bean class="com.vtkrishn.spring.Point">
<property name="x" value="20" />
<property name="y" value="0" />
</bean>
</property>

alias
-------
<alias name="triangle" alias="triangleAlias"/>

idref
--------
is used for validation of the refeence exists
<property name="message">
    <idref bean="zeroPoint" />
</property>

list, map , Set
------------------
<property name="points">
	<list>
		<ref bean="point0"/>
	</list>
   </property>


Bean autowiring
-------------------
autowire the content of the member variables automatically
the name should be same as that of the member variable
byName, byType, Constructor, autoDetect
