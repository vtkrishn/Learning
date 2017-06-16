public class YourClassNameHere {
    public static void main(String[] args) {
      String str = "vinod";
	  System.out.println(length(str));
    System.out.println(reverse(str));
	  System.out.println(equals(str,"ginod"));
	  System.out.println(indexOf(str,'r',0));
    }

    public static int length(String str){
      return (str == null || str.equals("")) ? 0 : (1 + length(str.substring(1)));
     }
	public static String reverse(String str){
      return (str == null || str.equals("")) ? "" : (reverse(str.substring(1)) + str.charAt(0));
     }
	public static boolean equals(String str1,String str2){
      if((str1 == null && str2 == null) || (str1.equals("") && str2.equals("")))
		return true;

      if(str1.length() != str2.length() || !str1.equals(str2))
		return false;

	   return equals(str1.substring(1),str2.substring(1));
     }

	public static int indexOf(String str,char ch, int i){
		if(str == null || str.equals(""))
			return -1;
		return 	(str.charAt(0) == ch) ? i : indexOf(str.substring(1),ch,i+1);
	}
}
