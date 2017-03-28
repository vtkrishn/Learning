public class YourClassNameHere {
	    public static void main(String[] args) {
	      int [] a = {1,2,3,4,6,7,8,9,10};
	      findMissingNumber(a);
	    }

	    public static void findMissingNumber(int[] arr){
	      int n = arr.length + 1;
	      System.out.println((n * (n+1))/2);

	      int x1=arr[0];
	      int x2=1;
	      for(int i=1;i<n-1;i++){
	        x1 = x1 ^ arr[i];
	      }

	      for(int i=2;i<=n;i++){
	        x2 = x2 ^ i;
	      }

	       System.out.println(x1 ^ x2);
	      }

	    }
