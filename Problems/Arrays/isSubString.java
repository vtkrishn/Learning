public class YourClassNameHere {
	    public static void main(String[] args) {
	      isSubString("waterbottle","erbottlewate");
	    }

	    public static void isSubString(String s1, String s2){
	      if(s1 == null || s2 == null)
	        return;

	      String result = s2+s2;
	      if(result.contains(s1))
	        System.out.println("true");
	       else
	        System.out.println("false");

	    }
	}
-------------------------------------------
public class YourClassNameHere {
	    public static void main(String[] args) {
	      isSubString("wateerbottle","erbottlewate");
	    }

	    public static void isSubString(String s1, String s2){
	      if(s1 == null || s2 == null)
	        return;

	     int len = 0;
	     for(int i=0;i<s2.length();i++){
	         if(s1.charAt(0) == s2.charAt(i))
	          len = s2.length()-i;
	     }
	     String a1 =s1.substring(0,len);
	     String b1 =s2.substring(s2.length()-len,s2.length());
	     String a2 =s1.substring(len,s1.length());
	     String b2 =s2.substring(0,s2.length()-len);

	     if(a1.equals(b1) && a2.equals(b2))
	      System.out.println("true");
	     else
	      System.out.println("false");

	    }
	}
