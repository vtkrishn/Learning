	* Java Preparation
	* http://docs.oracle.com/javase/tutorial/index.html
	* https://docs.oracle.com/javase/7/docs/api/
	*
	*
		* JVM Class loading

API: ![class](https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR91WZqpUVYZL1uUPrPOtu__RYMOXIM4LmLBMe2k0kwtQkCjSZSEA)

			* Loading
			* linking
			*
				* Verify
				* Prepare
				* Resolve
				*
					* NoclassDefFoundException (using new, could not resolve the class)
					* ClassNotFoundException (string not resolving)


			* Initialization
			* Runtime Data Area
			*
				* Method Area (Meta Space - Java 8)
				*
					* permGen (65) -XXMaxPermSize
					* outOfMemory Exception
					* will have the class Data

				* Heap
				*
					* -Xms,-Xmx
					* Java Objects

				* PC registers
				*
					* instructions for Threads - T1, T2.. etc
					*
						* per thread - will have stack frames to java stacks

					* per thread

				* Stack
				*
					* separate frames
					*
						* separate local variables
						* own operand stacks
						* StackOverflow Errors
						* frames will have access to Runtime constant pool
						* Dynamic Linking
						* method invocation completion

					* -Xss

				* Native Stacks
				* Execution Engine
				*
					* Interpreter
					* JIT Compiler
					* Hotspot profiler
					* Garbage Collector

				* Native Method Interface
				* Native Method Libraries

			* Bootstap ClassLoader (primodial) rt.jar, i18n.jar
			* Extension ClassLoader from lib/ext
			* Applications ClassLoader [System -classpath -cp]
			* https://www.youtube.com/watch?v=ZBJ0u9MaKtM
			*




               Data Types

	*
		* short, int, long, double, float, char, boolean, byte
		* Arithmetic instructions
		* Type conversions
		*
			* long to int, int to short etc

		* Object creation and manipulation
		*
			* new, array type
			* static fields, operand stack

		* Control transfers
		*
			* if , else, else if       


	* Java Programming Language
	*
		* Simple
		* Object oriented
		* Distributed
		* Multithreaded
		* Dynamic

		* Architecture neutral
		* Portable
		* High performance
		* Robust
		* Secure

	* Object
	*
		* State and Behavior

	* Class
	*
		* blueprint for an object

	* Interface
	*
		* group of related empty methods

	* Package
	*
		* organize




	*  Variables
	*
		* instance variables
		* class variables (Static)
		* method or local variables
		* parameters

	* Primitives
	*
		* byte - 8 bit
		* char - 16 bit
		* short - 16 bit
		* int - 32 bit (4 bytes)
		* float - 32 bit
		* long - 64 bit
		* double - 64 bit
		* boolean - 1 bit

	* Arrays
	*
		* container - holds fixed number of single type
		* contiguous memory location

	* Operators
	*
		* Assignment, Arithmetic, Unary
		* Equality, conditional
		* Bitwise, bit shift

	* Expression/Statements/Blocks
	* Control flow (if, else, switch)
	* Loops (for , while, do while)
	* Branching (break, continue, return)
	* Class and Objects
	*
		* Scope - public private - Access modifiers
		* methods, overloading
		* constructor
		* parameter  - pass by value

	* Creating Object
	*
		* new
		* instantiation
		* initialization (constructor)
		* this,this(), super, super()
		* modifier visiblity (private, default, protected, public)

	* Class Members
	*
		* Field Initialization
		* Static block ,static variables
		* Nested Classes
		*
			* Static nested classes
			* inner classes
			* Local and anonymous

		* Lambda Expressions

	* Enum Types
	* Annotations
	*
		* declaration
		* predefined
		* Repeating

	* Interface
	*
		* As Behavior
		* As Type
		* Default Methods
		* static default methods

	* Inheritance
	*
		* Casting
		* access
		* instance of

	* Polymorphism
	* Information hiding (Encapsulation)
	* Object class
	*
		* clone
		* equals
		*
			* == relation

		* hashcode
		*
			* objects memory address

		* finalize
		*
			* garbage collection

		* getClass
		* toString

	* Wrappers
	*
		*
		* compareTo
		* PrintStream
		* Format
		* DecimalFormat
		* Math
		*
			* abs
			* max
			* min
			* random


	* Characters
	* Strings
	*
		* intern
		* immutable
		*
			* substring
			* split
			* indexOf
			* lastIndexOf
			* charAt
			* toCharArray
			* toLowerCase/toUpperCase
			* contains
			* matches
			* replace


	* StringBuilder (not synchronized)
	*
		* append
		* reverse

	* Autoboxing/Unboxing
	* Generics
	*
		* for collection
		* Type
		* extending, subclass
		* key, value
		* wildcards
		* Type Erasure
		* Bridge method

	* Exceptions
	*
		* Throws exception
		*
			* forward and chain

		* try, catch, finally
		* try with resources
		* finally always executes
		* Errors are catched
		* RuntimeExcpetion not catched - should overcome,indexoutpufBound etc
		* checked exception 0 IO, Thread etc

	* Basic I/O
	*
		*
		* UnBuffered I/O
		*
			* Byte Stream (8 bit Byte)
			*
				* FileImputStream/FileOutputStream

			* Character Stream ()
			*
				* FileReader/FileWriter


		* Buffered I/O
		*
			* BufferedImputStream/BufferedOutputStream
			* BufferedReader/BufferedWriter
			* flushing the buffer

		* Scanning
		*
			* Scanner

		* Format
		*
			* PrintStream/PrintWriter
			* System.out.print / System.out.format

		* Read from CommandLine
		*
			* InputStreamReader/InputStreamWriter - System.in
			* Console - System.console

		* DataStream
		*
			* primitive streams in binary
			* DataStreamReader/DataStreamWriter
			* DataInpiut/DataOutput

		* ObjectStream
		*
			* ObjectInputStream/ObjectOutputStream
			* ObjectInput/ObjectOutput
			* readObject/writeobject
			* Serializable

		* NIO (Native IO)
		*
			* File, Path


	* Collection
	*
	* Collection
	*
		* add, remove, unordered, clear
		* traversal - steram support , iterator or foreach

	* Set
	*
		* no duplicate
		* HashSet
		*
			* LinkedHashSet

		* TreeSet (red black tree)

	* Map
	*
		* key value pair
		* no duplicate
		* HashMap
		*
			* permits null key and null values

		* LinkedHashMap
		* WeekHashMap
		* TreeMap (red black tree)
		*
			* keyset
			* values
			* entrySet

		* Multimap can be done using
		*
			* <String, <List<String>>


	* List
	*
		* ordered collection
		* LinkedList
		* ArrayList
		*
			* swap
			* sort
			* shuffle
			* rotate


	* Vector
	*
		* List with concurrency

	* Queue
	*
		* FIFO
		* add
		* remove
		* offer
		* poll
		* peek

	* Deque (Deck)
	*
		* FIFO or LIFO
		* ArrayDequue
		*
			* addFirst
			* addLast
			* removeFirst
			* removeLast


	* SortedSet
	*
		* range view
		* end points

	* SortedMap
	* Ordering
	*
		* Comparable
		*
			* compareTo

		* Comparator
		*
			* compare


	* Date/Time
	* Class or EnumYearMonthDayHoursMinutesSeconds*Zone OffsetZone IDtoString OutputWhere DiscussedInstant       2013-08-20T15:16:26.355ZInstant ClassLocalDate     2013-08-20Date ClassesLocalDateTime  2013-08-20T08:16:26.937Date and Time ClassesZonedDateTime2013-08-21T00:16:26.941+09:00[Asia/Tokyo]Time Zone and Offset ClassesLocalTime     08:16:26.943Date and Time ClassesMonthDay      --08-20Date ClassesYear       2013Date ClassesYearMonth      2013-08Date ClassesMonth       AUGUSTDayOfWeek and Month EnumsOffsetDateTime 2013-08-20T08:16:26.954-07:00Time Zone and Offset ClassesOffsetTime    08:16:26.957-07:00Time Zone and Offset ClassesDuration  ******  PT20H (20 hours)Period and DurationPeriod   ******P10D (10 days)Period and Duration
	* Concurrency
	*
		* Process - single process
		*
			* ProcessBuilder
			* own memory Space

		* Thread
		*
			* lightweight process
			* Main Thread deamon
			* Thread Object
			*
				* Implements Runnable

			* Thread.sleep() - InterruptedException -responds to interrupt
			* Thread.interrupted()
			* Thread.join() - interrupt
			*
				* wait for other thread to execute and complete

			* Synchronization
			*
				* sharing access and control and in sync
				* synchronized keyword - statement and method
				* intrinsic lock and monitor lock
				* thread cannot own lock of another thread
				* reentrant synchronization

			* Semaphore
			*
				* Binary semaphore
				*
					* 0 or 1
					* lock can be release other than the owner
					* acquire / release

				* counting semaphore
				*
					* increment
					* value more than 1

				* Signalling mechanism

			* Mutex
			*
				* either produce or consumer can work
				* one thread will hold the mutex
				* locking mechanism

			* Critcal section
			*
				* shared resource code

			* Atomic
			*
				* all primitives operations are atomic
				*
					* either completely done
					* or completely not done


			* Volatile - visibilty to other thread
			*
				* read current value before reading from local cache

			* Fairness policy
			*
				* Reentrantlock
				* longest waiting thread

			* Cyclic Barier
			*
				* allow all thread to come to one point

			* Countdown latch
			*
				* countdown to perform tasks

			* Liveness
			*
				* execute concurrently without any problem

			* Deadlock
			*
				* two or more thread waiting forever

			* Livelock
			*
				* two or more thread responds to each other forever

			* Starvation
			*
				* less problematic
				* thread wait forever being blocked with priority thread accessing the shared resource

			* Guarded Block
			*
				* wait for condition
				* Object.wait()
				* Object.notify(), notifyAll()


		* Immutable Objects
		*
			* final and private
			* all private

		* Locks
		*
			* advantage - bakcout of attempt to try Lock
			*



	* Executors
	*
		* launch new task
		* Executor -
		*
			* execute

		* ExecuteService,
		*
			* execute, submit

		* ScheduleExecutorService
		*
			* schedule - Callable or Runnable tasks


	* Thread Pool
	*
		* worker Thread
		*
			* finite thread pool

		* Fork/Join
		*
			* use multiple processor to break into small tasks and run parallelly


	* Concurrent Collection
	*
		* BlockingQueue
		* ConcurrentHashMap
		* ConcurrentMap
		* ConcurrentNavigableMap

	* Atomic Variables
	*
		* AtomicInteger

	* Concurrent RandomNubmers
	*
		* ThradLocalRandom

	*

	* JDBC
	*
	*
		* Connection con = DriverManager.getConnection(
                         "jdbc:myDriver:myDatabase",
                         username,
                         password);

    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM Table1");

    while (rs.next()) {
        int x = rs.getInt("a");
        String s = rs.getString("b");
        float f = rs.getFloat("c");
    }

	* Connection con = null;
        PreparedStatement pstmt = null;   

        try {
            con = DriverManager.getConnection(
                      "jdbc:default:connection");

            pstmt = con.prepareStatement(
                        "UPDATE EMPLOYEES " +
                        "SET CAR_NUMBER = ? " +
                        "WHERE EMPLOYEE_NUMBER = ?");

            pstmt.setInt(1, carNo);
            pstmt.setInt(2, empNo);
            pstmt.executeUpdate();
        }
        finally {
            if (pstmt != null) pstmt.close();
        }
	* JNDI
	*
		*

	* Hashtable<String, Object> env = new Hashtable<String, Object>();
env.put(Context.INITIAL_CONTEXT_FACTORY,
        "com.sun.jndi.ldap.LdapCtxFactory");
	* env.put(Context.PROVIDER_URL, "ldap://ldap.wiz.com:389");
env.put(Context.SECURITY_PRINCIPAL, "joeuser");
env.put(Context.SECURITY_CREDENTIALS, "joepassword");
	* env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

Context ctx = new InitialContext(env);
DirContext ctx = new InitialDirContext(env)
try {
    Context ctx = new InitialContext();
    Object obj = ctx.lookup("somename");
} catch (NamingException e) {
    // Handle the error
    System.err.println(e);
}

try {
    Context ctx = new InitialContext();
    Object obj = ctx.lookup("somename");
} catch (AuthenticationException e) {
    // attempt to reacquire the authentication information
    ...
} catch (NamingException e) {
    // Handle the error
    System.err.println(e);
}

BINDING
// Create the object to be bound
Fruit fruit = new Fruit("lemon");

// Perform the bind
ctx.rebind("cn=Favorite Fruit", fruit);

// Remove the binding
ctx.unbind("cn=Favorite Fruit");

SEARCHING
// ignore attribute name case
Attributes matchAttrs = new BasicAttributes(true);
matchAttrs.put(new BasicAttribute("sn", "Geisel"));
matchAttrs.put(new BasicAttribute("mail"));

// Search for objects that have those matching attributes
NamingEnumeration answer = ctx.search("ou=People", matchAttrs);

You can then print the results as follows.
while (answer.hasMore()) {
    SearchResult sr = (SearchResult)answer.next();
    System.out.println(">>>" + sr.getName());
    printAttrs(sr.getAttributes());

// Specify the ids of the attributes to return
String[] attrIDs = {"sn", "telephonenumber", "golfhandicap", "mail"};
SearchControls ctls = new SearchControls();
ctls.setReturningAttributes(attrIDs);
ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);


JAXP


Reflections
Class.forName()

SQL preparation


	* Linux Preparation


Garbage Collection

Hashing

LRU cache

Scalability

Design Patterns

DB Normalization

Algorithms & DS Preparation

	* REST - Representational State Transfer
	*
		*



     Resume Topics

Behacioral
