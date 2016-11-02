#include <iostream>

int main(){

  int a,b;
  std::cout << "enter the first number ";
  std::cin >> a;
  std::cout << "enter the second number ";
  std::cin >> b;
  if(a > b)
    std::cout << "first number is greater";
  else
    std::cout << "second number is greater";
  return 0;
}
