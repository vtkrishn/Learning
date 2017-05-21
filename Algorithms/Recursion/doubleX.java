// Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
//
// doubleX("axxbb") → true
// doubleX("axaxax") → false
// doubleX("xxxxx") → true
boolean doubleX(String str) {
  if(str == null || str.equals("") || str.length() <= 1)
    return false;
  if(str.charAt(0) == 'x' && str.charAt(1) != 'x')
    return false;
  if(str.charAt(0) == 'x' && str.charAt(1) == 'x')
    return true;
  return doubleX(str.substring(1));
}
