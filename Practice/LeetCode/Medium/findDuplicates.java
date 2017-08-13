public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<Integer>();
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                if(!result.contains(nums[i]))
                    result.add(nums[i]);
            }
        }
        return result;
    }
}
----------------
import java.util.*;
public class YourClassNameHere {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        findDuplicates(nums);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
}
