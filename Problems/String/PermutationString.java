public class YourClassNameHere {
	    public static void main(String[] args) {
	      permute("ABC","");
	    }
	    
	    static void permute(String str, String prefix){
	      if(str.length() == 0)
	        System.out.println(prefix);
	      else{
	        for(int i=0;i<str.length();i++){
	         permute(str.substring(0,i)+ str.substring(i+1),prefix+str.charAt(i)); 
	        }
	      }
	    }
	}
