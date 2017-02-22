public class YourClassNameHere {
	    public static void main(String[] args) {
	      int [] a = {1,2,3,4,5};
	      binarySearch(a,3);
	    }

	    public static void binarySearch(int[] arr,int key){
	      int start = 0;
	      int end = arr.length;

	      while(start < end){
	        int mid = start + end >>> 1;

	        if(key == arr[mid]){
	          System.out.println(mid);
	          break;
	        }

	        if(key < arr[mid])
	          end = mid-1;
	        else if(key > arr[mid])
	          start = mid+1;

	      }

	    }

}
