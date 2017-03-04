public class YourClassNameHere {
	    public static void main(String[] args) {
	       int[] arr1 = {1,2,3,5};
	       int[] arr2 = {4,6,9,11,12};
	       
	       mergeArray(arr1,arr2);
	    }
	    
	    static void mergeArray(int[] arr1,int[] arr2){
	      if(arr1 == null || arr2 == null)  
	        return;
	      
	      int i = 0;
	      int j = 0;
	      int k = 0;
	      
	      int[] combined = new int[arr1.length+arr2.length];
	      while(k<arr1.length+arr2.length){
	        if(i<arr1.length && arr1[i] <= arr2[j]){
	          combined[k++] = arr1[i++];
	        }
	        else{
	          combined[k++] = arr2[j++];
	        }
	      }
	      
	      while(j<arr2.length){
	        combined[k++] = arr2[j++];
	      }
	      
	      for(i=0;i<combined.length;i++){
	       System.out.println(combined[i]); 
	      }
	    }
	}
