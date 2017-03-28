public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] arr ={-1,0};
	      int max=arr[0];
	      int currentMax = arr[0];
        for(int i=1;i<arr.length;i++){
          int sum = currentMax + arr[i];
	        if(currentMax < sum){
	          currentMax = sum;
	        }
	        else{
	          currentMax=0;
	        }

	        if(currentMax != 0)
	          max = Math.max(max,currentMax);
       }
	    }

	    public static void insertionSort(int[] a,int key){
        for(int i=0;i<a.length;i++){
        	if(key==a[i]){
        		System.out.println("found at " + i + " position");
        	  break;
        	}
        }
	    }
}
