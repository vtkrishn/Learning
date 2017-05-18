public boolean nestParen(String str) {
  if(str.equals(""))
    return true;
  int len = str.length();
  if(str.charAt(0) == '(' && str.charAt(len-1) == ')')
      return nestParen(str.substring(1,len-1));
    else
      return false;
}
