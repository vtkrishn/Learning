##Thread contains these properties

###Name
* You can set name for the thread you are creating
  * t.setName("Running Thread")
  * or
  * Thread.currentThread.setName("Running Thread")

###Priority
* Threads can have priority between 1(MIN_PRIORTY) and 10(MAX_PRIORTY)
* Thread.currentThread.setPriority()
* IllegalArgumentException

###Id
* Stores the unique id for the thread. cannot set user value
* Thread.currentThread.getId();

###Status
* New - thread created but not started
* Runnable - thread started and is running
* Blocked - thread is blocked waiting to aquire a lock
* waiting - thread is waiting for the other thread to complete an action
* time waiting - thread is waiting for the other thread to complete an action upto a specific time
* Terminated - thread is stopped
* Thread.State.TERMINATED

###Deamons
* JVM exits only if all the threads are deamon threads
* IllegalThreadStateException is thrown if deamon is set after starting the thread. it should be set before starting the thread
* Deamon exists only at the mercy of user threads
* Will be used to service all other user threads
* its a low priority thread mostly used for background tasks
* isDeamon(true) or setDeamon(true)

###Interrupt
* Issue interrupt to notify the thread that its time to exit or return
* A thread can interrupt itself many number of times
* will throw InterruptedException, sleeping thread will throw this exception
* true value is set for Thread.currentThread.interrupt();
* within the thread Thread.currentThread.isInterrupted() check is made to return or not

###Sleep()
* put the current thread to sleep for some time
* kind of interrupt
* InterruptedException

###yield()
* pause the current thread to allow other thread to continue

###join()
* to wait for the completion of the thread
* thread finalization is done in join method
* InterruptedException
