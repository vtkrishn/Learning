//Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
public int countX(String str) {
  if(str == null || str.equals("") || str.length() == 0)
    return 0;
  int len = str.length();
  String sub = str.substring(0,1);
  String rem = str.substring(1,len);
  if(sub.equals("x"))
    return 1 + countX(rem);
  return countX(rem);
}
