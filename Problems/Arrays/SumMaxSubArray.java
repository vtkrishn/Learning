public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] arr={-2, -3, 4, -1, -2, 1, 5, -3};
	      maxContiguos(arr);
	    }
	    
	    static int maxContiguos(int[] arr){
	      if(arr == null)
	        return 0;
	     
	     int currentMax = 0;
	     int max = Integer.MIN_VALUE;
	     for(int i=0;i<arr.length;i++){
	       currentMax = Math.max(currentMax+arr[i],arr[i]);
	       max = Math.max(currentMax,max);
	     }
	      return max;
	    }
	}
