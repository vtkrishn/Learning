public class Solution {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int totalSum = len * (len + 1)/2;
        int sum = 0;
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for(int val : nums){
            if(!set.contains(val)){
                set.add(val);
                sum += val;
            }
            else
                result.add(val);
        }

        result.add(totalSum-sum);
        int[] res = new int[result.size()];
        int i=0;
        for(int r : result)
            res[i++] = r;

        return res;
    }
}
