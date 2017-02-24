public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] arr={3,3,4,4,5,4,4,5,4};
	      findOddNumber(arr);
	    }
	    
	    static int findOddNumber(int[] arr){
	      if(arr == null)
	        return 0;
	     
	     int result = 0;
	     for(int i=0;i<arr.length;i++){
	       result = result ^ arr[i];
	     }
	      return result;
	    }
	}
