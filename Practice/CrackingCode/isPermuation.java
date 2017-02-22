public class YourClassNameHere {
	    public static void main(String[] args) {
	      String str1 = "abcdefg";
	      String str2 = "defgakc";
	      System.out.println(isPermuation(str1,str2));
	    }
	    
	    static boolean isPermuation(String str1,String str2){
	      if(str1 == null || str2 == null)
	        return false;
	     
	     if(str1.length() != str2.length())
	       return false;
	     
	     //char[] ch = new char[128];
	     //for(int i=0;i<str1.length();i++){
	     //   ch[str1.charAt(i)]++;
	     //   ch[str2.charAt(i)]++;
	     //}
	     
	     //for(int i=0;i<str1.length();i++){
	     //   if(ch[str1.charAt(i)] <= 1)
	     //     return false;
	     //}
	     
	     String s3 = str1+str2;
	     
	     int j = 0;
	     for(int i=0;i<s3.length();i++){
	       j ^=s3.charAt(i)-'a';
	     }
	     
	      return true;
	    }
	}
