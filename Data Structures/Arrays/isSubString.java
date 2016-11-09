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
