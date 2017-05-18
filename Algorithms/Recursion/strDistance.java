public int strDist(String str, String sub) {
  if(str == null || str.equals(""))
    return 0;
  int strlen = str.length();
  int sublen = sub.length();
  if(strlen < sublen)
    return 0;
  if(str.substring(0,sublen).equals(sub)){
    if(str.substring(strlen-sublen,strlen).equals(sub))
      return str.length();
    else
      return strDist(str.substring(0, strlen-1), sub);
  }
  return strDist(str.substring(1),sub);
}
