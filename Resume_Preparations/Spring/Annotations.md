for @Required option
RequiredAnnotationBeanPostProcessor
org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor
<bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor"/>

@Autowired
done byType
<bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>
@Qualifier
to qualify the name

instead of adding each and every annotations we can add this
<context:annotation-config />


JSR 250 annotations
----------------------
@Resource
autowiring by name


as alternative for init and destroy methods
@PostConstruct
@PreDestroy


org.springframework.stereotype
@Component
@Service
@Repository
@Controller
for the class, role of the bean does, for human readabilty
<context:component-scan base-package="com.vtkrishn.circle">

lower case component name for bean name in the base-package name
