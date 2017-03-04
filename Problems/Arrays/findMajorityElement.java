public class YourClassNameHere {
	    public static void main(String[] args) {
	      int [] a = {1, 3, 3, 1, 2};
	      findMajority(a);
	    }

	    public static void findMajority(int[] arr){
	      if(arr == null)
	        return;

	      if(arr.length == 1)
	        System.out.println(arr[0]);

	      java.util.Map<Integer, Integer> m = new java.util.HashMap<Integer,Integer>();
	      int v = 0;
	      for(int i=0;i<arr.length;i++){
	         if(m.containsKey(arr[i])){
	            v = m.get(arr[i]);
	            v++;

    	        if(v > arr.length/2){
    	           System.out.println("Majority element : "+ arr[i]);
    	        }
	         }
	         else{
	           m.put(arr[i],1);
	         }

	      }

	    }
	}
//------------------
//Moore's voting Algoirthm

public class YourClassNameHere {
	    public static void main(String[] args) {
	      int [] a = {1, 3, 3, 3, 2};
	      findMajority(a);
	    }

	    public static void findMajority(int[] arr){
	      if(arr == null)
	        return;

	      if(arr.length == 1)
	        System.out.println(arr[0]);

	      int major = 0;
	      int count = 1;

	      for(int i=1;i<arr.length;i++){
	        if(arr[major] == arr[i])
	          count++;
	        else
	          count--;

	        if(count == 0){
	          major = i;
	          count = 1;
	        }

	      }

	        System.out.println(arr[major]);
	      }

	    }
