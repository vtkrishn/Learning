public class YourClassNameHere {
	    
	    static String f(String s,int length){
	     
	     if(length == s.length())
	        return "";
	     else{
	       System.out.println(s);
	        return f(s.substring(1), length++);
	     }
	    }
	    
	    public static void main(String[] args) {
	      f("abcdef",0);
	    }
	}
