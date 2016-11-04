#Solid property

##Single Responsibilty Principle
* Class should have single functionality/Responsibilty

##Open Close Principle
* Software should be open for extension and close for modification

##Liskov Substitution Principle
* Object should be able to replace with their subtypes

##Interface Segregation Principle
* maximum decoupling and no clas should implement a method which does not use

##Dependancy Inversion Principle
* High level module and low level module should depend on abstraction
* Details should depend on abstraction

##Design by contract
* All method invokers will know these things

* Side effects
* Pre condition
* Post condition
* invariant
* exceptions

#GRASP (General Responsibility Assignment Software Patterns)

* Expert
  * Assign Responsibility to those who know complete about the object
* Creator
  * Who creates object (Factory)
* Controller
  * How to delegate the request from UI to the object domain layer
* Low Coupling
  * how strong the objects are connected to each other
* High Cohesion
  * how much manageable or how its functionaly Dependant
* Polymorphism
  * how to handle based on different types  
* Pure Fabrication
  * fabricate the class to assign Responsibility which is not representing any db objects  
  * Adapter, Strategy
* Indirection
  * how to communicate between two objects, so that others are not direcly coupled
  * Adapter, Faceade, Observer
Don’t Talk to Strangers

#KISS
Keep it simple stupid
Class should have simple definition

#YAGNI
You aren'y Gonna need it
Dont write code unless completele necessary

#DRY
Dont Repeat Yourself
Dont repeat the functionality over and over

#Dependancy injection
* Inversion of control
* let others call you and dont call Yourself
* receiving the callee object in a constructor
