public class YourClassNameHere {
	    public static void main(String[] args) {
	      int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
	      findMaxSubArray(a);
	    }

	    public static void findMaxSubArray(int[] a){
	      int max = a[0];
	      int currentMax = a[0];

	      for(int i=1;i<a.length;i++){
	        currentMax = Math.max(a[i], currentMax + a[i]);
	        max = Math.max(currentMax, max);
	      }
	        System.out.println(max);
	      }

	    }
