#include <iostream>


int main(){

  int n;
  //get the value of rows
  std::cout << "Enter how many rows :";
  std::cin >> n;

/**
        *
        **
        ***
        ****
        *****
  */
  for(int i=0;i<n;i++){
    for(int j=0;j<=i;j++){
      std::cout << "*";
   }
   std::cout << std::endl;
  }

/**
        ******
        *****
        ****
        ***
        **
        *
*/
for(int i=n;i>=0;i--){
  for(int j=0;j<=i;j++){
    std::cout << "*";
 }
 std::cout << std::endl;
}
/**
  ******
   *****
    ****
     ***
      **
       *
*/
for(int i=n;i>=0;i--){
  for(int j=n;j>=0;j--){
    if(j<=i)
      std::cout << "*";
    else
      std::cout << " ";
 }
 std::cout << std::endl;
}

/**
         *
        **
       ***
      ****
     *****
    ******
*/
for(int i=n;i>=0;i--){
  for(int j=0;j<=n;j++){
    if(j>=i)
      std::cout << "*";
    else
      std::cout << " ";
 }
 std::cout << std::endl;
}
  return 0;
}
