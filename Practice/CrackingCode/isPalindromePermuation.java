public class YourClassNameHere {
	    public static void main(String[] args) {
	      String str = "baba";
	      System.out.println(isPalindrome(str));
	    }
	    
	   //static boolean isPalindrome(String str){
	   //    if(str == null)
	   //     return false;
	       
	   //    if(str.length() == 1)
	   //     return true;
	       
	   //    int count = 0;
	   //    char[] ch = new char[26];
	   //    for(int i=0;i<str.length();i++){
	   //      ch[str.charAt(i)-'a']++;
	   //    }
	        
	   //    for(int i=0;i<26;i++){
	   //      if(ch[i] % 2 == 1)
	   //       count++;
	   //    }
	       
	   //  return count <= 1;
	   // }
	   
	   
	   static boolean isPalindrome(String str){
	       if(str == null)
	        return false;
	       
	       if(str.length() == 1)
	        return true;
	       
	       int bitVector = 0;
	       int mask = 0;
	       for(int i=0;i<str.length();i++){
	         mask = 1 << (str.charAt(i)-'a');
	         if((bitVector & mask) == 0) 
              bitVector |= mask;  
           else
             bitVector &= ~mask;
	       }
	       
	     return bitVector == 0;
	    }
	}
