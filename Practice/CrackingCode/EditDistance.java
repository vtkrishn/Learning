public class YourClassNameHere {
	    public static void main(String[] args) {
	      String str1 = "poop";
	      String str2 = "omp";
	      System.out.println(findEditDistance(str1,str2));
	    }
	    
	   
	   static int findEditDistance(String str1, String str2){
	       if(str1 == null || str2 == null)
	        return -1;
	       
	       int count =0;
	       if(str1.length() == str2.length()){
	         for(int i=0;i<str1.length();i++){
	          if(str1.charAt(i) != str2.charAt(i))
	            count++;
	         }
	       }
	       else if(str1.length()>str2.length()){
	          //count = str1.length() - str1.indexOf(str2);
	          for(int i=0;i<str1.length();i++){
	           for(int j = 0;j<str2.length();j++){
	             if(str2.charAt(j) == str1.charAt(i)){
	               int left = i;
	               if(str2.charAt(j++) != str1.charAt(left++))
	                j=0;
	             }
	             break;
	           }
	           //if(str2.charAt(j) == str1.charAt(i)){
	           //  String temp = str1.substring(i,i+sliding);
	           // if(str2.equals(temp))
	           //   count = str1.length() - str2.length();  
	           //}
	          }
	       }
	       else if(str1.length()<str2.length()){
	          count = str2.length() - str2.indexOf(str1);
	       }
	       
	     return count;
	    }
	}
