public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i : nums){
            while(!stack.empty() && stack.peek() < i)
                map.put(stack.pop(),i);
            stack.push(i);
        }

        //construct findNums
        for(int i=0;i<findNums.length;i++)
            findNums[i] = map.getOrDefault(findNums[i],-1);
        return findNums;
    }
}
