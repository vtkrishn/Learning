public class YourClassNameHere {
	    public static void main(String[] args) {
	      int [] a = {1, 3, 3, 1,2};
	      findOddNumber(a);
	    }

	    public static void findOddNumber(int[] arr){
	      if(arr == null)
	        return;

	      if(arr.length == 1)
	        System.out.println(arr[0]);
	      int count = 0;
	      for(int i=0;i<arr.length;i++){
	        count = count ^ arr[i];
	      }

	        System.out.println(count);
	      }

	    }
