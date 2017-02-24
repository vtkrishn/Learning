public class YourClassNameHere {
	    public static void main(String[] args) {
	       System.out.println(findLargestRepeat("hoopla"));
	       System.out.println(findLargestRepeat("abbCCCddBBBxx"));
	       System.out.println(findLargestRepeat(""));
	       System.out.println(findLargestRepeat("xyz"));
	       System.out.println(findLargestRepeat("abbbcbbbxbbbx"));
	       System.out.println(findLargestRepeat("XXBBBbbxxXXXX"));
	       System.out.println(findLargestRepeat("XX2222BBBbbXX2222"));
	       
	    }
	    
	    static int findLargestRepeat(String str){
	      if(str == null || str.equals(""))
	        return 0;
	      
	      int startPosition=0;
	      int count = 0;
	      int maxCount = 0;
	      int start=0;
	      for(int i=1;i<str.length();i++){
	        if(str.charAt(i) == str.charAt(i-1)){
	          count++; 
	          if(count > maxCount){
  	          maxCount = count; 
  	          start = startPosition;
	          }
	        }
	        else{
	          count = 1;
  	        startPosition=i;
	        }
	        
	      }
	        return start;
	    }
	    
	}
