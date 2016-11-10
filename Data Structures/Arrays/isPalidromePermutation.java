public class YourClassNameHere {
	    public static void main(String[] args) {
	        isPalindrome("Tact Coaas");
	    }

	    public static boolean isPalindrome(String str){
	      if(str == null)
	        return false;

	      int sum = 0;
	      for(int i=0;i<str.length();i++){
	        int ch = str.toLowerCase().charAt(i);
	        if(ch != ' ')
	          sum = sum ^ ch;
	      }

	      if(sum == 0 || sum >=97 && sum <=122)
	        return true;

	      return false;
	    }
	}
