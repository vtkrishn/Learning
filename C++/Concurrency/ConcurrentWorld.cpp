#include <iostream>
#include <thread>

using namespace std;

void hello(){
    cout << "Concurrent Hello";
}

int main(){

  thread t(hello);
  t.join();
  return 0;
}
