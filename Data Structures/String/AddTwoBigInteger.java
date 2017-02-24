public class YourClassNameHere {
	    public static void main(String[] args) {
	      String str1 = "765";
	      String str2 = "0009";
	      
	      int diff = Math.abs(str1.length() - str2.length());
	      if(diff > 0){
	         int len1 = str1.length();
	         int len2 = str2.length();
	         
	            for(int i=0;i<diff;i++){
	              if(len1 > len2)
	                str2 = "0"+str2;
	              
	              if(len1 < len2)
	                str1 = "0"+str1;
	            }
	         
	      }
	      
	      System.out.println(addBigInteger(str1,str2));
	    }
	    
	    public static String addBigInteger(String str1, String str2){
	      
	      
	      char[] ch1 = str1.toCharArray();
	      char[] ch2 = str2.toCharArray();
	      
	      StringBuffer s = new StringBuffer();
	      
	      int count = 0;
	      int carry = 0;
	      for(int i=ch1.length-1;i>=0;i--){
	         count = carry + Math.abs(48-ch1[i]) + Math.abs(48-ch2[i]);
	         carry = count / 10;
	         count = count % 10;
	        s.append(count);
	      }
	      
	      return s.reverse().toString();
	    }
	    
	    
	    
	}
