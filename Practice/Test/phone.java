Symphony commerce
-----------------------------
static int longest;

int longestPath(Node n){
    if(n == null)
        return 0;

    longest = Math.max(diameter(n.left),diameter(n.right));
}

int diameter(Node n) {
    if(n == null)
        return 0;

    int leftHeight =  height(n.left);
    int rightHeight = height(n.right);

    return leftHeight + rightHeight + 1;
}

int height(Node root){

    if(root == null)
        return 0;

    int leftHeight =  height(n.left);       // 6 ->1
    int rightHeight = height(n.right);

    return Math.max(leftHeight,rightHeight) + 1;

}
---------------------------
MyVest
Q: Given an array of n integers where n > 1, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

For example: given [1,2,3,4], return [24,12,8,6].

[0] = 2 * 3 * 4
[1] = 1 * 3 * 4

public class Solution{

    public static void main(String[] args){
        int arr = {1,2,3,4};
        findProduct(arr);
    }


    private static int[] findProduct(int[] array){
        int totalProduct = array[0];
        int int[] result = new int[array.length];

        for(int i = 1;i<arr.length;i++){
            totalProduct = totalProduct * array[i];
        }

        for(int i = 0;i<arr.length;i++){
            result[i] = totalProduct / arr[i];
        }
    }

    return result;

    //total - 24
    //result[0] = 24/1 = 24
    //result[1] = 24/2 = 12
    //result[2] = 24/3 = 8
    //result[3] = 24/4 = 6
}
----------------
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

-------------------------
