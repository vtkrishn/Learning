#include <iostream>

int main(){

  int a, b;
  std::cout << "Enter the first number";
  std::cin >> a;
  std::cout << "Enter the second number";
  std::cin >> b;
  if(b % a == 0)
    std::cout << "Second number is divisible by the first number";
  else
    std::cout << "Second number is not divisble by first";
  return 0;
}
