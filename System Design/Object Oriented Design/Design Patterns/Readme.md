#Design Patterns

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
    

###Concurrency
