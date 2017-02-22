public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] arr = {1,2,3,4,5};
	      reverseArray(arr,0,4);
	    }
	    
	    static void reverseArray(int[] arr, int start, int end){
	      if(start > end)
	        return;
	      
	      int temp = arr[end];
	      arr[end] = arr[start];
	      arr[start] = temp;
	      reverseArray(arr, start+1,end-1);
	    }
	}
