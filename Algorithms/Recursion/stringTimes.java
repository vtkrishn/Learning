// Given a string and a non-negative int n, return a larger string that is n copies of the original string.
//
// stringTimes("Hi", 2) → "HiHi"
// stringTimes("Hi", 3) → "HiHiHi"
// stringTimes("Hi", 1) → "Hi"
public String stringTimes(String str, int n) {
  return n == 0 ? "" :str + stringTimes(str,n-1);
}
