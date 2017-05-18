public boolean strCopies(String str, String sub, int n) {
  if(str == null || str.equals(""))
    return false;
  return (strCopies(str,sub) == n);

}

public int strCopies(String str, String sub){
  int strlen = str.length();
  int sublen = sub.length();

  if(strlen < sublen)
    return 0;

  if(str.substring(0,sublen).equals(sub))
    return 1 + strCopies(str.substring(1),sub);
  return strCopies(str.substring(1),sub);
}
