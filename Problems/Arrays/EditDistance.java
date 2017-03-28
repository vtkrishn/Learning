public class YourClassNameHere {
	    public static void main(String[] args) {
	        editDistance("pale","pa");
	        editDistance("pale","pal");
	        editDistance("pale","sal");
	        editDistance("pale","pales");
	        editDistance("pale","sales");
	        editDistance("pale","sale");
	        editDistance("dfge","sale");
	    }

	    public static boolean editDistance(String s1, String s2){
	      if(s1 == null || s2 == null)
	        return false;

	      int l1 = s1.length();
	      int l2 = s2.length();

	      if(l1+1 == l2)
	        return s2.contains(s1);

	      if(l2+1 == l1)
	        return s1.contains(s2);

	      int count = 0;
	      if(l1 == l2){
	        for(int i=0;i<l1;i++){
	          if(s1.charAt(i) != s2.charAt(i)){
	            count++;
	          }
	          if(count > 1)
	            return false;
	        }

	        return true;
	      }

	    return false;
	    }
	}
