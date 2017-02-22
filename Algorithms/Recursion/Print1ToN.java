public class YourClassNameHere {
	    
	    static void f(int n){
	     
	     System.out.println(n);
	     
	     if(n == 10)
	        return;
	     else
	        f(n+1);
	        
	    }
	    
	    public static void main(String[] args) {
	      f(0);
	    }
	}
