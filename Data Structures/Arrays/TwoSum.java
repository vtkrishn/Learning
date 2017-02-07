import java.util.*;

public class Solution{

    public static void main(String[] args){
        int[] arr = {1,3,5,7};
        System.out.println(findIndex(arr,4));
    }

    private static List<Integer> findIndex(int[] array, int target){
        List<Integer> listResult = new ArrayList<Integer>();
        if(array == null)
            return listResult;

        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        for(int i=0;i<array.length;i++){

            if(map.containsKey(array[i])){
                listResult.add(map.get(array[i]));//1
                listResult.add(i);//2
                //break;
            }
            else{
                map.put(target-array[i],i);
            }

            //8-1, 0 -> 7,0
            //8-3, 1 -> 5,1
            //8-5, 2 -> 3,2
        }

        return listResult;

    }

}
