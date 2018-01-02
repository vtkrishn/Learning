@Aspect
@After
@Before
@AfterReturning
@AfterThrowing
@Around
Advice
@Pointcuts(execution)
@Pointcuts(within)
@Pointcuts(args())
Jointcut
ProceedingJointcut

XML schema based
<aop:config>
   <aop:aspect id = "myAspect" ref = "aBean">
      ...
   </aop:aspect>
