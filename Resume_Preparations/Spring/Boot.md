Maven
pom.xml for dependencies

  <parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>1.4.2.RELEASE</version>
  </parent>

  <dependencies>
  <dependency><groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  </dependency>

  </dependencies>

  <properties>
  <java.version>1.8</java.version>
  </properties>
</project>

-------------------
file
Annotation - SpringBootApplication
this one in main method of the java class - SpringApplication.run(CourseApiApp.class, args);

@SpringBootApplication
public class CourseApiApp {

	public static void main(String[] args) {
		SpringApplication.run(CourseApiApp.class, args);
	}

Spring Boot what does
------------------
Create the servlet container
configure bean and instantiate
setup appplication context
start the tomcat server

controller
---------------
@RestController
@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}
