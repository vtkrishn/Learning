public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] m = {5,6,7,9,8};
	      rotate(m);
	    }

	    public static void rotate(int[] arr){
	      if(arr == null)
	        return;

	      reverse(arr, 0, 1);
        reverse(arr, 2, arr.length-1);
        reverse(arr, 0, arr.length-1);
	    }

	    public static void reverse(int[] arr, int start, int end){
	      if(arr == null)
	        return;

	      int mid = start + end >>> 1;
	      int i=start;
	      int j=end;
	      while(i <= mid){
	         int temp = arr[i];
	         arr[i] = arr[j];
	         arr[j] = temp;
	         i++;
	         j--;
	      }
      }
  }
