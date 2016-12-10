Garbage Collection is like
malloc()
ralloc()
free()
new and destructor

reachable object
old object referring to new object

live object
object in your application that is referred in another object
reach the root node -  main method

Objects are allocated in heap (new command)
Array is also an object

static , class (permgen, metaspace)

Garbage collection - deamon thread
System.gc() static method
java.lang.outOfMemoryError() - jvm could not allocate more memory space
heap space
- object leaks
- memory leaks

Steps
Mark - marking referenced and unreferenced objects
Delete/Sweep - delete unreferenced objects
Compacting - contguous fragment allocation

Generations
Generational collectors

Stop the world GC - minor or Major
Major is drastic [mark - sweep - compacting]
Heap divided into
Young (Minor GC)
  New Objects are created - Eden space
  Survivor space - all eden move to survivor (small GC)
  Two survivor space to avoid another run for compacting which is expensive
  Survivor from (S1)
  Survivor to (S2)
Old (Tenured) (Major GC)
 from Survivor to Old

Survivor moved to survivor1 to survivor2 and vice versa upto a threshold value
-XX:MaxTenuringThreshold
moved from Young Generation to Old Generation

Major GC - includes Young and Old Generation
Application Halting

Garbage collectors
Serial Garbage Collector
  single thread
  small heap size

Concurrent Garbage collector
  concurrent thread
  don't wait for old generation to be full
  runs along with Application
  does not pauses in most of the case unless mark and remark

Parallel Garbage collector
 kicks in only if old reaches some percentage
 multiple CPU
 does not run Concurrent - stop the world

When to use different collectors
more CPU , more memory, application responsive and less latency - concurrent GC (low latency) most web application financial applications
less memory , less CPU , high throughput - parallel GC

java 7 and above
G1 garbage collectors
Garbage first
divides heap into small space (wherever there is more garbage then it will be collected first)
when u want to pause

-XX:+UseSerialGC - single for both young and old generation
-XX:+UseParallelGC - young in parallel, old will be in single threaded
-XX:+UseParallelOldGC - use parallel in young and old
-XX:+UseConcurrentMarkSweepGC - only in old generation
-XX:+UseParNewGC - use parallel only in young gc and old can be set for concurrent mark and Sweep
-XX:+UseG1GC - upto java 7 default is parallel, its java 7 and above

finalize() method - no guarantee when GC happens, but all closing statements goes here

-Xms - minimum heap
-Xmx - maximum heap (def. 256 mb)
-XX:NewRatio - Young and Old ratio
-XX:NewSize -eden space
-XX:MaxNewSize - max eden size
-XX:PermSize -perm gen
-XX:MaxPermSize - max perm size (64 MB)

How to print GC
-XX:PrintGCDetails
-verbose:gc
-Xloggc:gc.log

jvisualvm
JHAT - Java Heap Analyzer Tool
Jrockit
http://www.oracle.com/technetwork/java/javase/memorymanagement-whitepaper-150215.pdf

c:\Users\vtkrishn.ORADEV\Desktop>java -Dcom.sun.management.jmxremote.port=3333 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Xms1m -Xmx14m test

c:\Users\vtkrishn.ORADEV\Desktop>java -Dcom.sun.management.jmxremote.port=3333 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Xms1m -Xmx3m -XX:+PrintGC test
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

c:\Users\vtkrishn.ORADEV\Desktop>java -Dcom.sun.management.jmxremote.port=3333 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Xms1m -Xmx3m -XX:+PrintGCDetails test
[GC (Allocation Failure) [PSYoungGen: 512K->400K(1024K)] 512K->408K(1536K), 0.0025834 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [PSYoungGen: 912K->512K(1024K)] 920K->568K(1536K), 0.0025354 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [PSYoungGen: 1024K->512K(1024K)] 1080K->736K(1536K), 0.0029276 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [PSYoungGen: 1024K->512K(1024K)] 1248K->904K(1536K), 0.0028784 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[Full GC (Ergonomics) [PSYoungGen: 512K->501K(1024K)] [ParOldGen: 392K->324K(2048K)] 904K->825K(3072K), [Metaspace: 5346K->5346K(1056768K)], 0.0139627 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
