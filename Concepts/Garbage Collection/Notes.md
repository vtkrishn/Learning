#### Reference
https://www.youtube.com/watch?v=UnaNQgzw4zY

* Java automatically support Garbage collection
* for languages like C++, we are responsible to freeing the memory in our program

#### What if we do not free?
* Memory leaks
* Application running out of Memory

#### C++ uses
* malloc()
* ralloc()
* calloc()
* free()
* new
* destructor

#### Java
* Live Object : Can be reachable (referred by someone)
* Dead Object / Old Object: unreachable object (Not referred by any one)

#### Hypothesis
* Most object soon become unreachable
* only small number will be referring the new Objects

#### How in java
* Objects are allocated in heap space in Java (new command)
* Array is also an object (Heap)
* static , class definitions (permgen, metaspace)
>![](http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/images/gcslides/Slide1.png)
#### About GC
* Garbage collection is carried out by  deamon thread - Garbage Collector
* System.gc() static method

#### What it means
* java.lang.outOfMemoryError() - jvm could not allocate more memory space
  * heap space
  * object leaks
  * memory leaks

#### How its done
* Mark - marking referenced and unreferenced objects, walks through the object graph in memory, each node marks it
* Delete/Sweep - delete unreferenced objects, whichever is marked as reachable. unreachable objects are deleted
* Compacting - contiguous fragment allocation, will have holes, like disk defragmentation

#### Generations in Java Heap
* In java Generational collectors
	* It depends on generation of the objects , if young or old
>![](http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/images/gcslides/Slide5.png)
* Stop the world GC - minor or Major
 	* minor is short amount of memory
 	* major will work on complete heap to Mark, Sweep, and compact
 	* Major GC - includes Young and Old Generation - Application Halting (for 3 or 4 seconds)
		* Major is drastic [mark - sweep - compacting]

#### What Heap contains?
* Young (Minor GC)
  * New Objects are created
  	* like new HashMap();
  * Eden space (reference to genesis new objects)
    * Survivor space - all eden move to survivor (small GC)
    * Two survivor space to avoid another run for compacting which is expensive
    * Survivor from (S1)
    * Survivor to (S2)
* Old (Tenured) (Major GC)
	* move from Survivor to Old

* Survivor moved to survivor1 to survivor2 and vice versa upto a threshold value
	* -XX:MaxTenuringThreshold
* Moved from Young Generation to Old Generation
* Survivor threashold objects staying upto threshold all objects promoted from Young to Old Generation

#### GC in terms of Application
* Responsiveness/Latency - UI related (GC should not take more time)
* Throughput - (Batch processing Application) focuses on amount work in some time(some pauses are ok)

#### Garbage collectors

###### Serial Garbage Collector
* very basic, used for small amount of heap
* single thread of GC, mark, sweep, compact

###### Concurrent Garbage collector
* concurrent thread along with the application - GC runs
* don't wait for old generation to be full
* runs along with Application
* does not pauses in most of the case unless mark and remark

###### Parallel Garbage collector
* kicks in only if old reaches some percentage
* multiple CPU, multiple threads
* does not run Concurrent - will stop the application

#### When to use different collectors
* concurrent GC (low latency) - CMS
	* more CPU , more memory, good application responsive and less latency
	* most web application financial applications
	* most favoured
* parallel GC -
	* less memory,less CPU ,high throughput

#### G1 Garbage Collector
* G1 garbage collectors - java 7 and above
* Garbage first , both concurrent and parallel
* divides heap into small space (wherever there is more garbage then it will be collected first)
* when u want to pause
>![](https://i.ytimg.com/vi/UnaNQgzw4zY/maxresdefault.jpg)

#### Different command arguments

* -XX:+UseSerialGC - single for both young and old generation
* -XX:+UseParallelGC - young in parallel, old will be in single threaded
* -XX:+UseParallelOldGC - use parallel in young and old
* -XX:+UseConcurrentMarkSweepGC - only in old generation
* -XX:+UseParNewGC - use parallel only in young gc and old can be set for concurrent mark and Sweep
* -XX:+UseG1GC - upto java 7 default is parallel, its java 7 and above

#### Finalizer
* protected void finalize() method -
* guaranteed to be called before GC, but no guarantee of when GC happens
* all db, io closing statements goes here
* advice  not to use anything

#### Java options
-Xms - minimum heap to be allocated to the program
-Xmx - maximum heap (def. 256 mb)
-XX:NewRatio - Young and Old ratio - how to divide 2 means 2/3 -for old, 1/3 for young
-XX:NewSize - total eden space size
-XX:MaxNewSize - max eden size
-XX:PermSize - total perm gen
-XX:MaxPermSize - max perm size (def. 64 MB)

#### How to print GC
* -XX:PrintGCDetails
* -verbose:gc
* -Xloggc:gc.log

#### Tools
* jvisualvm
* JHAT - Java Heap Analyzer Tool
* Jrockit - http://www.oracle.com/technetwork/java/javase/memorymanagement-whitepaper-150215.pdf

#### Checking
>c:\Users\vtkrishn.ORADEV\Desktop>java -Dcom.sun.management.jmxremote.port=3333 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Xms1m -Xmx14m test

>c:\Users\vtkrishn.ORADEV\Desktop>java -Dcom.sun.management.jmxremote.port=3333 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Xms1m -Xmx3m -XX:+PrintGC test
```
[GC (Allocation Failure)  512K->408K(1536K), 0.0017038 secs]
[GC (Allocation Failure)  920K->576K(1536K), 0.0017612 secs]
[GC (Allocation Failure)  1088K->728K(1536K), 0.0019512 secs]
[GC (Allocation Failure)  1240K->904K(1536K), 0.0018695 secs]
[Full GC (Ergonomics)  904K->825K(3072K), 0.0106195 secs]
[GC (Allocation Failure)  1337K->1129K(3072K), 0.0023680 secs]
Performing GC
Performing GC[GC (Allocation Failure)  1641K->1665K(3072K), 0.0034392 secs]

Performing GC[GC (Allocation Failure)  2177K->2198K(3072K), 0.0036665 secs]
[Full GC (Ergonomics)  2198K->2117K(3584K), 0.0364177 secs]
```
>c:\Users\vtkrishn.ORADEV\Desktop>java -Dcom.sun.management.jmxremote.port=3333 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Xms1m -Xmx3m -XX:+PrintGCDetails test
```
[GC (Allocation Failure) [PSYoungGen: 512K->400K(1024K)] 512K->408K(1536K), 0.0025834 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [PSYoungGen: 912K->512K(1024K)] 920K->568K(1536K), 0.0025354 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [PSYoungGen: 1024K->512K(1024K)] 1080K->736K(1536K), 0.0029276 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [PSYoungGen: 1024K->512K(1024K)] 1248K->904K(1536K), 0.0028784 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[Full GC (Ergonomics) [PSYoungGen: 512K->501K(1024K)] [ParOldGen: 392K->324K(2048K)] 904K->825K(3072K), [Metaspace: 5346K->5346K(1056768K)], 0.0139627 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
```
