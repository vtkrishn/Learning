#REST
REpresentational State Transfer

* web standard
* HTTP
* simple and reliable
* stateless

#Design of REST
    * Understandability − Both Server and Client should be able to understand and utilize the representation format of the resource.
    * Completeness − Format should be able to represent a resource completely. For example, a resource can contain another resource.
            Format should be able to represent simple as well as complex structures of resources.
    * Linkablity − A resource can have a linkage to another resource, a format should be able to handles such situations.

#components of HTTP Request
* Verb - GET,PUT,POST, PATCH
* URI - to identify the resource server - host
* Http version - version
* Request Header - clietn agents, meta data information
* Request Body - message

#components of HTTP Response
* Status / Code - response code
* Http version - version
* Response Header - clietn agents, meta data information
* Response Body - message

#URI
<protocol>://<service-name>/<ResourceType>/<ResourceID>

#BEST PRACTICES
* Use Plural Noun − Use plural noun to define resources. For example, we've used users to identify users as a resource.
* Avoid using spaces − Use underscore_ or hyphen -  when using a long resource name, for example, use authorized_users instead of authorized users.
* Use lowercase letters − Although URI is case-insensitive, it is good practice to keep url in lower case letters only.
* Maintain Backward Compatibility − As Web Service is a public service, a URI once made public should always be available. In case, URI gets updated, redirect the older URI to new URI using HTTP Status code, 300.
* Use HTTP Verb − Always use HTTP Verb like GET, PUT, and DELETE to do the operations on the resource. It is not good to use operations names in URI.

#Statelessness
* no need to keep track of clients Request
* each request independant
* no need to remember previous Request

#VERBS
GET PUT POST DELETE OPTIONS

@GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)

@GET
  @Path("/users/{userid}")
  @Produces(MediaType.APPLICATION_XML)

@PUT
 @Path("/users")
 @Produces(MediaType.APPLICATION_XML)
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

@POST
@Path("/users")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

@DELETE
@Path("/users/{userid}")
@Produces(MediaType.APPLICATION_XML)

@OPTIONS
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)


#Service
package com.tutorialspoint;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {

   UserDao userDao = new UserDao();

   @GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   public List<User> getUsers(){
      return userDao.getAllUsers();
   }
}
https://www.tutorialspoint.com/restful/restful_methods.htm

#Web.xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xmlns="http://java.sun.com/xml/ns/javaee"
   xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
   http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
   id="WebApp_ID" version="3.0">
   <display-name>User Management</display-name>
   <servlet>
      <servlet-name>Jersey RESTful Application</servlet-name>
      <servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
         <init-param>
            <param-name>jersey.config.server.provider.packages</param-name>
            <param-value>com.tutorialspoint</param-value>
         </init-param>
      </servlet>
   <servlet-mapping>
   <servlet-name>Jersey RESTful Application</servlet-name>
      <url-pattern>/rest/*</url-pattern>
   </servlet-mapping>  
</web-app>
