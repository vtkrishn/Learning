public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] arr={1,3,4,5,6};
	      findMissing(arr);
	    }
	    
	   // static int findMissing(int[] arr){
	   //   if(arr == null)
	   //     return 0;
	   //  int n = arr.length;
	   //  int total = (n+1) * ((n+1) + 1)/2; // n+1 because we have to find the sum of total including the missing number
	   //  for(int i=0;i<arr.length;i++){
	   //     total = total - arr[i]; 
	   //  }
	   //   return total;
	   // }
	    
	    static int findMissing(int[] arr){
	      if(arr == null)
	        return 0;
	     int xor1 = arr[0];
	     for(int i=1;i<arr.length;i++){
	        xor1 = xor1 ^ arr[i]; 
	     }
	     int xor2=  1;
	     for(int i=2;i<=arr.length+1;i++){
	        xor2 = xor2 ^ i; 
	     }
	     
	      return xor1 ^ xor2;
	    }
	}
