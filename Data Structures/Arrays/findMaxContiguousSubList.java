public class YourClassNameHere {
	    public static void main(String[] args) {
	          int[] arr = {34,45,56,1,2,3,4,67,78,8,9,10,11,344,56,37,3,4,5,6,7};
	          findMaxSubList(arr);
	    }

	    public static void findMaxSubList(int[] arr){
	      if(arr == null)
	        return;

	      int[] result;
	      int max = 0;
	      int currMax=0;
	      int start = 0;
	      int end = 0;
	      int prevStart = 0;
	      int prevEnd = 0;
	      for(int i=1;i<arr.length;i++){
	        if(Math.abs(arr[i] - arr[i-1]) == 1){
	          if(currMax == 0)
	            start = i-1;
	          currMax++;
	        }
	        else{
	          if(currMax  != 0)
	              end = i-1;
	          if(currMax > max){
	            max = currMax;
	            prevStart = start;
	            prevEnd = end;
	          }
	          currMax = 0;
	        }
	      }

	      int l = arr.length-1;
	      if(Math.abs(arr[l] - arr[l-1]) == 1)
	        end = l;

	      if(currMax > max){
	            max = currMax;
	            prevStart = start;
	            prevEnd = end;
	          }

	    }
	}
