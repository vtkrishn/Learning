#include <iostream>
#include <thread>

using namespace std;

class background_task{

public:
    void operator ()(){ //operator definition or constructor
        doSomeWork();   //calling the function
    }
    void doSomeWork(){
        cout<<"Inside a class";
    }
};

void hello(){
    cout << "Concurrent Hello";
}

int main(){
  background_task f; // object reference

  thread my_thread1(f); // calling the reference in the thread wil intanciate by calling the constructor

  thread my_thread2((background_task())); // can be called like this
  thread my_thread3{background_task()}; // can be called like this - uniform initialization syntax

  my_thread1.join();
  my_thread2.join();
  my_thread3.join();

  return 0;
}
