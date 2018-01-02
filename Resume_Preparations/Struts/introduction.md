https://struts.apache.org/getting-started/
struts
mvc framework
interceptors - front controller
servlet
action class
JSP

struts 2
struts xml
action -> Business Service
JSP

web.xml

struts2 - filter
filterMapping

namespaces -
-----------------
access the site using .action suffix

<package namespace="/tutorials" extends="struts-default">
  <action name="getTutorial" class="com.vtkrishn.TutorialAction">
    <result name="success">/success.jsp</result>
    <result name="failure">/failure.jsp</result>
  </action>
</package>

execute() is the method
getTutorial - is something we will access as getTutorial.action
----------------
Tags
taglib
struts-tag

-----------
Session
Request

New Actions created for each of the requests

ValueStack
Action objects with member varialbe stored inside ValueStack

Valuestack.actionObject.membervariables

----------------
Interceptor - is to pass the input parameter to the action for procesing
--------------
include option
include another struts login.xml file in the mail struts.xml
--------------
Action interface
 Some static strings like SUCCESS, LOGIN, ERROR
 execute() method
Action wildcards -
search{1}.jsp
search*.jsp

ActionSupport class
  validate() method
  addFieldError(fieldName, message)

before execute() called it calls validate
-----------
can have different packages and Actions

Action method mapping - if we want to execute a method

<action name="getTutorial" class="com.vtkrishn.TutorialAction" method="someMethod">
  <result name="success">/success.jsp</result>
  <result name="failure">/failure.jsp</result>
</action>
</package>

otherwise execute() method will get called

ModelDriven - getModel()
implements ModelDriven for using pojo objects within action and wanted to set the content automatically
------------------------

interceptors - its like filters

struts2 itself acts as filters
all validations , params etc.
used for cross cutting concerns
if u want to do something common across all the objects

configurable, java class
pluggable filters

<interceptors name="params" class="com.vtkrishn.AutoInterceptors">

interceptors stack
<interceptor-ref>

multiple interceptors
