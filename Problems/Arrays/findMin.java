public class YourClassNameHere {
	    
	    public static int findMin(int[] arr){
	     
	     int len = arr.length;
	     
	     if(len == 1 || arr[0] < arr[len-1])
	        return arr[0];
	     
	     int lo = 0;
	     int hi = len -1;
	     int mid = 0;
	     
	     while(lo < hi){
	       
	       mid = lo + (hi-lo)/2;
	       
	       if(arr[mid] < arr[mid-1])
	          return arr[mid];
	          
	       if(arr[mid] < arr[0])
	          hi = mid-1;
	       else
	          lo = mid+1;
	     }
	     
	     return arr[mid];
	     
	    }
	   
	    public static void main(String[] args) {
	      int[] arr = {1};
	      System.out.println(findMin(arr));
	    }
	}
