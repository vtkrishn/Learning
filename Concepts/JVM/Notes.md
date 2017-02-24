>![](https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/JvmSpec7.png/400px-JvmSpec7.png)

* Load and Execute

#### Steps in java
* create javafile
* call javac javafile
* java javafile

#### Class Loaders
* loads application .class file
* load build in class files (String, Object, collection classes - JAVA API)
* Execution Engine - to execute byte code
  * interact with Operating system to execute instruction sets
  * native api calls

##### Load (executed in order)
* Bootstrap - load rt.jar - Bootstrap (String, Objects, Collections etc - JAVA API)
* Extension - load extension jars (jre/jlib/ext)
* Application - load .class from different source (application class, from jar files)
  * Classpath, -cp etc

##### Link (overlap or executed in parallel)
* Verify
  * looks at the bytecode
  * check if compatible for JVM (magic number check)
* Prepare
  * memory is allocated for static variable inside the class
  * defaulting of static values
* Resolve
  * all symbolic references are resolved
  * reference to other classes
  * constant pool etc
* Initialize
  * static gets executed
  * values of static variables gets assigned

* classNotFoundException - class loader could not find the class
* ClassDefNotFoundException - resolve phase , while resolving it could not find the definition

#### Runtime Data Area
* Method Area (Not Thread Safe created for per JVM)
  * Class data is stored
  * permGen Space (Java 8 Metaspace) default - 64mb
  * OutOfMemory - Error
* Heap (Not Thread Safe created for per JVM)
  * Objects gets stored here - anything to do with objects stored here
* Program Counter
  * Thread - T1, T2
  * points to the next instruction
* Java Stack
  * Methods are references as stack frames
    * stack frames - created per thread (Thread cannot see different stack frames - thread safe)
    * has date to current method, operand stack  
  * StackOverFlowError -  recursive calls
  * Native method stack - for native calls

#### Execution Engine
* Interpreter
  * uses native dll to interpret the instructions, .so etc
  * JNI
* JIT
  * repeated instructions are compiled on the fly
  * frequently used instructions
* Hotspot Profiler
  * profiles the JIT
* Garbage Collector  
  * scavenging activity
