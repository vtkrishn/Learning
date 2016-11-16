public class BinarySearch {
	    public static void main(String[] args) {
	      int[] a = {1,2,3,4,5,6,7};
	      System.out.println(search(a,-1)); // lower negative
	      System.out.println(search(a,0)); // zero check
	      System.out.println(search(a,1)); // lower positive
	      System.out.println(search(a,3)); // middle
	      System.out.println(search(a,4)); // middle
	      System.out.println(search(a,7)); // upper positive
	      System.out.println(search(a,10));// upper negative
	    }

      //search function
      public static int search(int[] a,int n){
	      int low = 0;
	      int high = a.length -1;
	      return binarySearch(a,n,low,high);
	    }

      //binary search helper
      //every recursion is reduced to two levels - O(log n)
	    public static int binarySearch(int[] a,int n,int low, int high){
        //find the mid element
        int mid = low + (high-low)/2; // or mid + low >>> 1;

        //if mid element is equal then return the mid element
	      if(a[mid] == n)
	        return mid;
	      //if element is greater than mid element then update the low value
	      if(n > a[mid]){
	        low = mid + 1;
	      }
	      else{
          //if element is lesser than mid element then update the high value
	        high = mid-1;
	      }

        //low and high should not cross each other
	      if(low > high)
	        return -1;

	      return binarySearch(a,n,low,high);
	    }
	}
