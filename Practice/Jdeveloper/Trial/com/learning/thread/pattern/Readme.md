#Half-Sync/Half-Async Pattern
For easy understanding I have taken factorial as an example for explaining this pattern
https://github.com/zezutom/concurrency-patterns/tree/master/half-sync-half-async

Source contains two files
* FactorialComputation.java
* Factorial.java

##FactorialComputation.java
this is the main class which does the following
* Creates a task scheduler (ExecutorService)
* schedule 3 task to compute factorial for (10,12,15) by submitting the task (ex.submit())
* the task when completed will return the result to respective Futrue object (f1,f2,f3)
* prints the result when the result is available (f1.get(), f2.get(), f3.get())

##Factorial.java
This class will compute the factorial of the given number
* the overloaded constructor will store the number for which factorial needs to be calculated
* implements Callable interface
* in the call() method invoke the facorial methodf
