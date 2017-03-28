public class YourClassNameHere {
	    public static void main(String[] args) {
	     
        int arr[][] = {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                      };	      
	    
	    findAdjacent(arr,5);
	    }
	    
	    
	    static void findAdjacent(int[][] arr, int value){
	     if(arr == null)
	      System.out.println("Array Empty");
	     
	     boolean top = false;
	    boolean middle = false;
	    boolean bottom = false;
	    
	    boolean left = false;
	    boolean center = false;
	    boolean right = false;
	    
	      for(int i=0;i<arr.length;i++){
	          
	        for(int j=0;j<arr.length;j++){
	            
	      if(value == arr[i][j]){
	              
	         if(i%3==0)
	          top = true;
	        else if(i%3==1)
	          middle = true;
	        else if(i%3==2)
	          bottom = true;
	         
	            if(j%3==0)
	              left = true;
	            else if(j%3==1)
	              center = true;
	            else if(j%3==2)
	              right = true;
	              
	              
	              if(top && left){
	                System.out.println(arr[i][j+1]); 
	                System.out.println(arr[i+1][j]); 
	                System.out.println(arr[i+1][j+1]); 
	              }
	              else if(top && center){
	                System.out.println(arr[i][j-1]); 
	                System.out.println(arr[i][j+1]); 
	                System.out.println(arr[i+1][j-1]); 
	                System.out.println(arr[i+1][j]); 
	                System.out.println(arr[i+1][j+1]); 
	              }
	              else if(top && right){
	                System.out.println(arr[i][j-1]); 
	                System.out.println(arr[i+1][j-1]); 
	                System.out.println(arr[i+1][j]); 
	              }
	              
	              if(middle && left){
	                System.out.println(arr[i-1][j]);
	                System.out.println(arr[i-1][j+1]);
	                System.out.println(arr[i][j+1]);
	                System.out.println(arr[i+1][j]); 
	                System.out.println(arr[i+1][j+1]); 
	              }
	              else if(middle && center){
	                System.out.println(arr[i-1][j-1]);
	                System.out.println(arr[i-1][j]);
	                System.out.println(arr[i-1][j+1]);
	                System.out.println(arr[i][j-1]);
	                System.out.println(arr[i][j+1]);
	                System.out.println(arr[i+1][j-1]); 
	                System.out.println(arr[i+1][j]); 
	                System.out.println(arr[i+1][j+1]); 
	              }
	              else if(middle && right){
	                System.out.println(arr[i-1][j]);
	                System.out.println(arr[i-1][j-1]);
	                System.out.println(arr[i][j-1]);
	                System.out.println(arr[i+1][j]); 
	                System.out.println(arr[i+1][j-1]);
	              }
	              
	              if(bottom && left){
	                System.out.println(arr[i-1][j+1]); 
	                System.out.println(arr[i-1][j]); 
	                System.out.println(arr[i][j+1]); 
	              }
	              else if(bottom && center){
	                System.out.println(arr[i][j-1]); 
	                System.out.println(arr[i][j+1]); 
	                System.out.println(arr[i-1][j-1]); 
	                System.out.println(arr[i-1][j]); 
	                System.out.println(arr[i][j-1]); 
	              }
	              else if(bottom && right){
	                System.out.println(arr[i-1][j]); 
	                System.out.println(arr[i-1][j-1]); 
	                System.out.println(arr[i][j-1]); 
	              }
	              
	            }
	        }
	      }
	    }
	  
	}
	
	
