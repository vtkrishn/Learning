public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] arr ={5,2,4,6,1,3};
	      insertionSort(arr);
	    }
	    
	    public static void insertionSort(int[] a){
        for(int i=1;i<a.length;i++){
          int temp = 0;
          int j=0;
            while(j<i)	{
              if(a[j] > a[i]){
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
              }
            j++;
            }
        }
	    }
	}
