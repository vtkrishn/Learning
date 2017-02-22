public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] a = {1,2,3,4,5,6,7,8};
	      int k = 3;
	      int j=0;
	      for(int i=0;i<a.length;i+=k){
	        j = i+k-1;
	        if(j==a.length){
	          j--;
	        }
  	        int temp = a[i];
  	        a[i] = a[j];
  	        a[j] = temp;
	      }
	      
	      for(int i=0;i<a.length;i++){
	        System.out.println(a[i]);
	      }
	    }
	}
