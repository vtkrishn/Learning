public class YourClassNameHere {
	    public static void main(String[] args) {
	      int [] a = {4,5,1,2,3};
	      binarySearch(a,3);
	    }

	    public static void binarySearch(int[] arr,int key){
	      int start = 0;
	      int end = arr.length;
	      int dip = 0;

        //find the dip
        for(int i=1;i<end;i++){
	        if(arr[i] < arr[i-1]){
	          dip = i;
	         break;
	        }
	      }

        //update the start and end according to the dip
	      if(key < arr[start])
	        start = dip;
	      else
	        end = dip;

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
