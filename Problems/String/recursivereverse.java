
public static String reverse(String s){
  if(s.equals(""))
    return "";
  return reverse(s.substring(1)) + s.substring(0,1);
}
