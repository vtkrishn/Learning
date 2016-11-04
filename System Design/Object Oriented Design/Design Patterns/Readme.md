#Design Patterns

###Basic
#Delegation
#Interface
#Marker
#Immutable

###Creational
#Factory
    provide interface to create objects
    let subclass decides which one to instantiate
    new is considered harmful
    usually called withing Template methods
    eg . Injection Mold - DuckMold/CarMold
#Abstract Factory
    provide interface to create family of o bjects
    new is considered harmful
    eg. Animal ,SeaAnimalFactory, LandAnimalFactory
#Builder
    parse a complex representation
    create one of several
    focuses on constructing complex object step by step
    builds a Composite
    eg. Cashier, restraunt
#Singleton
    ensures the class having only one instance
    eg. Calender.getInstance()  
#Prototype
    cloning an object
    eg. SingleCell , Cell
#Object pool
    reusable pool of objects and restrict creation of new objects

###Structural
#Adapter
    matches interface of different classes
    # Socket USB
#Bridge
    decouples an abstraction from its implementation so that two can vary independantly
    eg. Swithch and SwitchImplementation
#Composite
    Tree structure of simple and composite objects
    eg. Tree.leaf node. etc, recursion
#Decorator
    Add responsibilty dynamically
    eg. Horizzontal bar and vertical bar
#Flyweight
    sharing usage of fine granualrity for better efficiency
    eg. heavy weight object to light weight components
#Facade
    front line object for all point of contact
    eg. customer service executive
#Proxy
    Object representation reducing cost of creating the complex object
    eg. Proxy and real subject
###Behavioral
#Chain of responsibilty
    passing request between chain of objects
    eg. ATM denomiation of currency
#Command
    encapsulate command request
    eg. command execution. Waiter Order cook executes the order
#Interpreter
    language element parsing
    eg. Piano. notes, singnals, signatures
#Iterator
    sequenctial access of a collection of objects
    eg. TV channel navigation
#Mediator
    Defines the object that encasulates how the other objects interact
    eg. Airport terminal Mediator for flight landing
#Memento
    Externalization of object state
    eg. undo redo.. object state is retained at each modification  
#Observer
    Notification of changes
    eg. Auction bidding.
#State
    alters objects behavior with a state change
    eg.vending machine.. deposit state and delivery state
#Null Object
    to mark an absence of an object
#Vistor
    allows an operation to be performed on the object without changing the class on which it operates
    eg. cashier, products.. visitable object. 
#Strategy
      encapsulate algorithm inside a class
      eg. airport shuttle. car, bus, van based on number of people
#Template method
      defines exact steps to the subclass
      eg. Worker, electrician, plumber, postman all are working

###Concurrency
