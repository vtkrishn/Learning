public class LinearSearch {
	    public static void main(String[] args) {
        //initialize the array
        int[] a={4,5,6,7,3,5,9};
	      int n = 7;
        boolean flag = false;
        //access all the elements to check if any of the number is equal to the search number - O(n)
        for(int i=0;i<a.length;i++){
          //if the number is equal then print and exit the loop
          if(n == a[i]){
	          System.out.println("Item found at :" + i);
	          flag = true;
	          break;
	        }
	      }
        //if there is no element found then print that there is no element found
	      if(!flag)
	        System.out.println("Item Not found");
	    }
	}
