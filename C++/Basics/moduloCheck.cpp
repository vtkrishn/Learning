#include <iostream>

int main(){

  int a,mod,quot;
  std::cout << "Enter the value : ";
  std::cin >> a;
  mod = a;
  //print reverse
  // while(mod != 0){
  //   quot = mod % 10;
  //   mod = mod / 10;
  //   std::cout << quot << "\t";
  // }

  mod = a;
  int div = 1;
  //find the position of the digits
  for(int i=mod;i>0;i=i/10){
    div *= 10;
    std::cout << div << std::endl;
    //std::cout << div << std::endl;
  }

  // a = temp % 10;
  // temp = temp / 10;
  // std::cout << a << "\t";
  // a = temp % 10;
  // temp = temp / 10;
  // std::cout << a << "\t";
  return 0;
}
