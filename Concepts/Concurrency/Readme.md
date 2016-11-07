#Java
https://docs.oracle.com/javase/8/docs/api/index.html?java/util/concurrent/package-summary.html

#Concurrency
Running more than one task simultaneosly within a single processor

#Parallelism
dividing the problem into subtask and combining the problem using threads
fork / join mechanism
ExecutorService is meant for this

#Shared Resources
In a concurrent environment some of the resources are meant for shared access
each thread will have their own local copy and most of the resources will be shared for synchronized access

#Race Condition
eg. Two threads trying the increment and decrement simultaneosly resulting in a race condition

#Contention
Two or more thread uses the shared resources simultaneosly which causes the jvm to run slowly
Starvation and livelocks are form of thread contention

##Starvation
priority thread keeps acquiring the lock and low priority keeps on waiting and unable to progress
greedy threads takes access to shared Resources

##Liveness
Concurrent application should execute in a timely manner
if there are any problems then it will be
Deadlock or livelock

###Deadlock
one thread is waiting for the other thread to release the lock and keep waiting forever

###Livelock
both the threads responding to the action of the other threads
too busy responding to others than resuming the work assigned

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

#Thread Local

#Non Blocking Data structures

#Message passing

#Synchronization

#Mutex

#Semaphone

#priority Inversion

#Context Switch

#Preemptive
#Non Preemptive

#SpinLock

#Critical Section

#Conpare and Swap

#Read modify write

#Thread Group

#Reentrant Lock

#Read Write Locking

#countdown latch

#producer consumer

#Atomic Variables

#Barrier

#Volatile

#Fairness Policy

#Guarded Blocking


#Executors

#Timers
