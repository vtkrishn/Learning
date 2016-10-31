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

int k=0;
for(int i=1; i<=n; ++i, k=0){
        for(int space=1; space<=n-i; ++space){
            std::cout << "  ";
        }
        while(k != 2*i-1){
            std::cout << "* ";
            ++k;
        }
        std::cout << std::endl;
    }
    for(int i=n; i>=1; --i){
          for(int space=0; space < n-i; ++space)
              std::cout << "  ";
          for(int j=i; j <= 2*i-1; ++j)
              std::cout << "* ";
          for(int j=0; j < i-1; ++j)
              std::cout << "* ";
        std::cout << std::endl;
      }
  return 0;
}
