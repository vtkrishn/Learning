public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] arr={3,3,4,4,5,4,4,5,4,5};
	      if(hasMajority(arr) > arr.length);
	        System.out.println("Element is there");
	    }
	    
	    static int hasMajority(int[] arr){
	      if(arr == null)
	        return 0;
	     
	     int maxIndex = 0;
	     int count = 1;
	      for(int i=1;i<arr.length;i++){
	        if(arr[maxIndex] == arr[i]){
	          count++; 
	        }
	        else{
	          count--; 
	        }
	        
	        if(count == 0){
	          maxIndex = i;
	          count = 1;
	        }
	      }
	      
	      return maxIndex;
	    }
	}

public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] x = {3, 3, 4, 2, 4, 4, 2, 4};
	      System.out.println(getMajority(x));
	    }
	    
	    static int getMajority(int[] arr){
	        if(arr == null)
	          System.out.println("Array Empty");
	         
	         java.util.Map<Integer,Integer> countMap = new java.util.HashMap<Integer,Integer>();
	         for(int i =0;i<arr.length;i++){
	            if(countMap.containsKey(arr[i]))
	              countMap.put(arr[i],countMap.get(arr[i])+1);
	            else
	              countMap.put(arr[i],1);
	         }
	         
	         java.util.Collection s = countMap.values();
	         java.util.Iterator<Integer> it = s.iterator();
	         while(it.hasNext()){
	          int v = it.next();
	          if(v > arr.length/2)
	            return v;
	         }
	         
	         return 0;
	    }
	}
