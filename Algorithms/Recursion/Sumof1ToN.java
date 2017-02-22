public class YourClassNameHere {
	    
	    static int f(int n,int value){
	     
	     if(n == 0)
	        return 0;
	     else
	      return n + f(n-1, value+1);
	    }
	    
	    public static void main(String[] args) {
	      System.out.println(f(10,1));
	    }
	}
