public class YourClassNameHere {
	    public static void main(String[] args) {
	        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
	        int max = a[0];
	        int currentMax = a[0];
	        for(int i=1;i<a.length;i++){
	          currentMax = currentMax + a[i];
	          if(currentMax<0){
	            currentMax = 0;
	          }
	          else{
	           max = Math.max(max,currentMax);
	          }
	        }
	    }
	}
