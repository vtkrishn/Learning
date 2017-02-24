public class YourClassNameHere {
	    public static void main(String[] args) {
	      String str1 = "7655";
	      String str2 = "5445";//41310
	      
	      System.out.println(productBigInteger(str1,str2));
	    }
	    
	    public static int productBigInteger(String str1, String str2){
	      
	      
	      char[] ch1 = str1.toCharArray();
	      char[] ch2 = str2.toCharArray();
	      int count = 0;
	      int[][] a = new int[str1.length()][str1.length()];
	      
	      for(int i=0;i<str1.length();i++){
	        for(int j=0;j<str2.length();j++){
	       a[i][j] = Math.abs(48-ch1[i]) * (int)Math.pow(10,(str1.length()-(i+1)))
	       
	            * Math.abs(48-ch2[j]) * (int)Math.pow(10,(str2.length()-(j+1)));  
	        }
	      }
	      
	      for(int i=0;i<str1.length();i++){
	        for(int j=0;j<str2.length();j++){
	            count = count + a[i][j];
	          }
	        }
	          
	      return count;
	    }
	    
	    
	    
	}
