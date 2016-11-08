#Java
https://docs.oracle.com/javase/8/docs/api/index.html?java/util/concurrent/package-summary.html
http://tutorials.jenkov.com/java-concurrency/index.html

#Concurrency
* Running more than one task simultaneosly within a single processor

#Parallelism
* dividing the problem into subtask and combining the problem using threads
* fork / join mechanism
* ExecutorService is meant for this

#Concurrency Model
* Delegate Worker
* Assembly Line

#Shared Resources
* In a concurrent environment some of the resources are meant for shared access
* each thread will have their own local copy and most of the resources will be shared for synchronized access

#Race Condition
* eg. Two threads trying the increment and decrement simultaneosly resulting in a race condition
* This will happen inside the critical section
* multiple thread share the same resources, safe to read but write will be a problem
* you can add a synchronized keyword or lock or use Atomic variables
* use AtomicInteger - compareAndSet(), compareAndSwap()
    while(true){
      int current = get();
      int next = current + 1;
      if(compare(current,next))
        return next;
    }

#Critical Section
* increment or decrement code is the critical section
* All local variables are thread safe
* All local reference are shared and stored as objects in shared heap

#synchronized
* block can be for method synchronized void add()
* inside a method synchronized(this)
* for static method synchronized static void add()

#Volatile
* Thread reads from cpu cache memory and not form main memory
* volatile keywork make sure that the thread always reads from the main memory
* Visiblity problem - Thread not seeing the latest value

#Thread Local
* Create variables that can be read and written only by the same thread
* usage initialValue(), get(), set()
* InheritableThreadLocal allows access for all threads and its child
private ThreadLocal myThreadLocal = new ThreadLocal<String>() {
    @Override protected String initialValue() {
        return "This is the initial value";
    }
};

#Missed Signal
* sometime the notify may be missed by the thread

#spurious wakeups
* sometime thread wakes up without the notify from other thread

#Busy wait
* thread waits for other thread to signal to proceed
* CPU utilization is high on wait

#Thread Signalling
* signalling between thread with some shared variable as signal flag
* wait(), notify(), notifyAll()

#Contention
* Two or more thread uses the shared resources simultaneosly which causes the jvm to run slowly
* Starvation and livelocks are form of thread contention

##Starvation
* priority thread keeps acquiring the lock and low priority keeps on waiting and unable to progress
* greedy threads takes access to shared Resources
* all threads waiting to enter the sync block simultaneously

#Fairness
* use locks instead of Synchronization ie. guard critical section using locks
* Fair Lock

##Liveness
* Concurrent application should execute in a timely manner
* if there are any problems then it will be
* Deadlock or livelock

###Deadlock
* one thread is waiting for the other thread to release the lock and keep waiting forever
* Database deadlock - waiting for the transaction to complete - SQL UPDATE dependant on another UPDATE
* Deadlock prevention
  * lock ordering
  * lock timeout
  * deadlock detection

###Livelock
* both the threads responding to the action of the other threads
* too busy responding to others than resuming the work assigned

#SpinLock
* wait call within while loop is called spin lock
* while(isLocked)

#response time

#throughput

#ACID rule

#Locking mechanism

#Concurrency Control
* Two phase Locking
* Time stamp ordering
* Graph Checking
* multiversion concurrency Control
* index concurrency Control

#Thread Pool



#Non Blocking Data structures

#Message passing

#Synchronization

#Mutex

#Semaphone

#priority Inversion

#Context Switch

#Preemptive
#Non Preemptive





#Conpare and Swap

#Read modify write

#Thread Group

#Reentrant Lock

#Read Write Locking

#countdown latch

#producer consumer

#Atomic Variables

#Barrier

#Guarded Blocking


#Executors

#Timers
