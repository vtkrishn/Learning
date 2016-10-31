#include <iostream>

int main(){

  int a;
  std::cout << "Enter the number to check if its even or not";
  std::cin >> a;
  if(a % 2 == 0)
    std::cout << "The number is even";
  else
    std::cout << "The number is odd" << std::endl;
  return 0;
}
