public class YourClassNameHere {
	    public static void main(String[] args) {
	      int [] a = {1,2,7,-2,-3,8};
	      findArrayPairsOfSum(a,5);
	    }

	    public static void findArrayPairsOfSum(int[] arr,int key){
	      if(arr == null)
	        return;

	      if(arr.length == 1 || arr[0] == key)
	        System.out.println(arr[0]);

	      java.util.Map<Integer, Integer> m = new java.util.HashMap<Integer,Integer>();
	      for(int i=0;i<arr.length;i++){
	         if(m.containsKey(arr[i])){
	            System.out.println(arr[i] + "," + m.get(arr[i]));
	         }
	         else{
	           m.put(key-arr[i],arr[i]);
	         }
	      }

	    }
	}
