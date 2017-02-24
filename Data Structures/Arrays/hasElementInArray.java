public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] x = {1,-2};
	      hasElements(x,-1);
	    }
	    
	    static void hasElements(int[] arr, int query){
	        if(arr == null)
	          System.out.println("Array Empty");
	         
	         boolean[] b = new boolean[100];
	         for(int i =0;i<arr.length;i++){
	            int temp = query-arr[i];
	            if(temp >= 0 && b[temp] || temp < 0 && b[Math.abs(temp)])
	              System.out.println("[" +arr[i] + "," + temp+ "]");
	            
	            b[Math.abs(arr[i])]=true;   
	         }
	    }
	}
