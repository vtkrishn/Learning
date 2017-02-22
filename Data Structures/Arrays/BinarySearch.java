public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] arr={3,4,5,6,7};
	      System.out.println(binarySearch(arr,4));
	    }
	    
	   // static int binarySearch(int[] a,int value){
	   //   if(a == null)
	   //     return 0;
	     
	   //  int low = 0;
	   //  int high = a.length-1;
	   //  int mid=0;
	   //  while(low < high){
	   //     mid = low + (high-low)/2;
	        
	   //     if(value <= a[mid])
	   //       high = mid;
	   //    else
	   //       low = mid+1;
	   //  }
	     
	   //  return mid;
	   // }
	    
	    static int binarySearch(int[] a,int value){
	      if(a == null)
	        return -1;
	     
	     return binarySearch(a,0,a.length-1,value);
	    }
	    
	    static int binarySearch(int[] a,int low, int high,int value){
	       if(low > high)
	        return -1;
	       
	       if(high == low)
	        return low;
	       
	       int mid = low + (high-low)/2;
	       
	       if(value <= a[mid]) 
	        high = mid;
	       else
	        low = mid+1;
        
        return binarySearch(a,low,high,value);
	    }
	}
