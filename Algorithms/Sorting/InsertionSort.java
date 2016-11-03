public class YourClassNameHere {
	    public static void main(String[] args) {
        //init array elements
        int[] a = {5,4,3,1,2,9,0};
        //call the sort function
        sort(a);
	    }

      /*
      * Insertion Sort function
      */
	    public static void sort(int[] a){
        //loop all elements in the array - O(n)
        for(int i=1;i<a.length;i++){
          int j=0;
          //loop 1 less than i always - O(n)
          while(j<i){
             //if a[i] < a[j] then swap the two numbers
             if(a[i]<a[j]){
	              int temp = a[i];
	              a[i] = a[j];
	              a[j] = temp;
	           }
	           else{
	              j++;
	           }
	        }
	      }
	    }
	}
