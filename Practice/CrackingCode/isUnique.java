public class YourClassNameHere {
	    public static void main(String[] args) {
	      String str = "abcdeee";
	      System.out.println(isUnique(str));
	    }
	    
	   // static boolean isUnique(String input){
	   //   if(input == null)
	   //     return false;
	   //  char[] ch = new char[128];   
	   //   for(int i=0;i<input.length();i++){
	   //    ch[input.charAt(i)]++;
	   //    if(ch[input.charAt(i)] > 1)
	   //     return false;
	   //   }
	      	      
	   //   return true;
	   // }
	    
	    
	    static boolean isUnique(String input){
	      if(input == null)
	        return false;
	     int checker = 0;
	     for(int i=0;i<input.length();i++){
	       int val = input.charAt(i)-'a';
	       if((checker & (1 << val)) > 0)
	        return false;
	        
	       checker |= (1 << val); 
	      }
	      	      
	      return true;
	    }
	}
