public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] arr={3,4,5,-1,-2};
	      
	      System.out.println(binarySearch(arr,-2));
	      //System.out.println(rotated_binary_search(arr,arr.length,-2));
	    }
	  
// 	    static int rotated_binary_search(int A[], int N, int key) {
//   int L = 0;
//   int R = N - 1;
 
//   while (L <= R) {
//     // Avoid overflow, same as M=(L+R)/2
//     int M = L + ((R - L) / 2);
//     if (A[M] == key) return M;
 
//     // the bottom half is sorted
//     if (A[L] <= A[M]) {
//       if (A[L] <= key && key < A[M])
//         R = M - 1;
//       else
//         L = M + 1;
//     }
//     // the upper half is sorted
//     else {
//       if (A[M] < key && key <= A[R])
//         L = M + 1;
//       else
//         R = M - 1;
//     }
//   }
//   return -1;
// }

	    static int binarySearch(int[] a,int value){
	      if(a == null)
	        return -1;
	    
	    int low = 0;
	    int high = a.length-1;
	    int mid = low + (high-low)/2;
	    
	    if(value == a[mid])
	      return a[mid];
	    
	    if(value == a[mid])
	      return mid;
	    
	    if(a[low] < a[mid] && value > a[low])
	      high = mid;
	    else
	     low = mid + 1;
	    
	     return binarySearch(a,low,high,value);
	    }
	    
	    static int binarySearch(int[] a,int low, int high,int value){
	        
         if(low > high)
	        return -1;
	       
	       if(high == low)
	        return a[low] == value ? low : -1;
	       
	       int mid = low + (high-low)/2;
	       
	       if(value <= a[mid]) 
	        high = mid;
	       else
	        low = mid+1;
        
        return binarySearch(a,low,high,value);
	    }
	}
