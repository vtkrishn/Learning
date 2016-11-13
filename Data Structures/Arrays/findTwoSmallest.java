public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] m = {7,8,5,4,1,3,8};
	      findTwoSmallest(m);
	    }

	    public static void findTwoSmallest(int[] arr){
	      if(arr == null)
	        return;

	      int first = Integer.MAX_VALUE;
	      int second = Integer.MAX_VALUE;
	      for(int i=0;i<arr.length;i++){
	        if(arr[i] < first)
	          first = arr[i];

	        if(arr[i] > first && arr[i] < second)
	          second = arr[i];
	      }

	    }

  }
