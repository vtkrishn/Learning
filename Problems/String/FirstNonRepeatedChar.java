public class YourClassNameHere {
	    public static void main(String[] args) {
	        String s = "Salesforce is the best company to work for” returns";
	        s = s.toLowerCase();
	        int i =0;
	        String k = null;
	        String charAt = null;
	        while(i<s.length()){
	          charAt = ""+s.charAt(i);
	          k = s.substring(++i);	          
	         if(!k.contains(charAt))
	            break;
	        }
	        
	        System.out.println(charAt);
	    }
	}
