public int sumDigits(int n) {
  if(n <= 0)
    return 0;
  //int m = n % 10;
  //return m + sumDigits(n / 10);
  return (n % 10) + sumDigits(n / 10);
}
