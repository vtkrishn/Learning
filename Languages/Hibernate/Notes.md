#### ORM
* Object relational Mapping
>![](https://www.tutorialspoint.com/hibernate/images/hibernate_position.jpg)
* Java Persistent Objects
* Properties file
* XML Mapping
>![](https://www.tutorialspoint.com/hibernate/images/hibernate_high_level.jpg)

#### Important
* Configurations
  * hibernate.cfg.xml
  * Database connection information
* SessionFactory
  * Heavy weight
* Session
  * light weight
* Transaction
  * unit of work
* Query
 * HQL
* Criteria
 * Query Criteria

##### hibernate.cfg.xml
hibernate.dialect - choose Database
connection Driver
connection URL
connection username
connection password
pool size
auto-commit

##### SessionFactory
>factory = new Configuration().configure().buildSessionFactory();

><?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-configuration SYSTEM
"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
   <session-factory>
   <property name="hibernate.dialect">
      org.hibernate.dialect.MySQLDialect
   </property>
   <property name="hibernate.connection.driver_class">
      com.mysql.jdbc.Driver
   </property>
   <!-- Assume test is the database name -->
   <property name="hibernate.connection.url">
      jdbc:mysql://localhost/test
   </property>
   <property name="hibernate.connection.username">
      root
   </property>
   <property name="hibernate.connection.password">
      root123
   </property>
   <!-- List of XML mapping files -->
   <mapping resource="Employee.hbm.xml"/>
</session-factory>
</hibernate-configuration>

##### Session
>Session session = factory.openSession();
Transaction tx = null;
try {
   tx = session.beginTransaction();
         Employee employee = new Employee(fname, lname, salary);
         employeeID = (Integer) session.save(employee);
         tx.commit();
}
catch (Exception e) {
   if (tx!=null) tx.rollback();
   e.printStackTrace();
}finally {
   session.close();
}

>List employees = session.createQuery("FROM Employee").list();
employee.setSalary( salary );
session.update(employee);

>Employee employee = Employee)session.get(Employee.class, EmployeeID);
session.delete(employee);

>Criteria cr = session.createCriteria(Employee.class);
// To get records having salary more than 2000
cr.add(Restrictions.gt("salary", 2000));
// To get records having salary less than 2000
cr.add(Restrictions.lt("salary", 2000));
// To get records having fistName starting with zara
cr.add(Restrictions.like("firstName", "zara%"));
cr.setProjection(Projections.rowCount());
// To get average of a property.
cr.setProjection(Projections.avg("salary"));


##### Mapping file
><?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-mapping PUBLIC
 "-//Hibernate/Hibernate Mapping DTD//EN"
 "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping>
   <class name="Employee" table="EMPLOYEE">
      <meta attribute="class-description">
         This class contains the employee detail.
      </meta>
      <id name="id" type="int" column="id">
         <generator class="native"/>
      </id>
      <property name="firstName" column="first_name" type="string"/>
      <property name="lastName" column="last_name" type="string"/>
      <property name="salary" column="salary" type="int"/>
   </class>
</hibernate-mapping>

#### Caching
>![](https://www.tutorialspoint.com/hibernate/images/hibernate_cache.jpg)

* First Level
* cfg file
><property name="hibernate.cache.provider_class">
      org.hibernate.cache.EhCacheProvider
   </property>

* Second Level
  * Mapping file   
><cache usage="read-write"/> read-only , transactional

Query Level Cache
>Session session = SessionFactory.openSession();
Query query = session.createQuery("FROM EMPLOYEE");
query.setCacheable(true);
List users = query.list();
SessionFactory.closeSession();

##### Batch processing
* cfg file
><property name="hibernate.jdbc.batch_size">
      50
   </property>

>Session session = factory.openSession();
      Transaction tx = null;
      Integer employeeID = null;
      try{
         tx = session.beginTransaction();
         for ( int i=0; i<100000; i++ ) {
            String fname = "First Name " + i;
            String lname = "Last Name " + i;
            Integer salary = i;
            Employee employee = new Employee(fname, lname, salary);
            session.save(employee);
         	if( i % 50 == 0 ) {
               session.flush();
               session.clear();
            }
         }
         tx.commit();   
