public class YourClassNameHere {
	    public static void main(String[] args) {
	        isUnique("aaaabbcd");
	        isUnique("abcd");
	    }

	    public static boolean isUnique(String str){
	      if(str == null)
	        return false;

	      int[] ch = new int[26];
	      for(int i=0;i<str.length();i++){
	        int c = str.charAt(i);
	        ch[c-97]++;

	        if(ch[c-97] > 1)
	          return false;
	      }
	      return true;
	    }
	}
