public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] arr ={5,2,4,6,1,3};
	      insertionSort(arr,4);
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
