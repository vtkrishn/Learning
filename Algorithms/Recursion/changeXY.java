public String changeXY(String str) {
  if(str == null || str.equals(""))
    return str;
  if(str.charAt(0) != 'x')
    return str.charAt(0) + changeXY(str.substring(1));
  return  'y' + changeXY(str.substring(1));
}
