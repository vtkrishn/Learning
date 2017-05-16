//Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).
public int factorial(int n) {
  if(n==0 || n == 1 || n == 2)
   return n;
  return n * factorial(n-1);
}
