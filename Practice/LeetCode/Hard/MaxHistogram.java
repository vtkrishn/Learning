class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i=0;i<=heights.length;i++){
            int value = i == heights.length ? 0 : heights[i];
            if(stack.isEmpty() || value >= heights[stack.peek()])
                stack.push(i);
            else{
                int top = stack.pop();
                max = Math.max(max, heights[top] * (stack.isEmpty() ? i : i-1-stack.peek()));
                i--;
            }
        }
        return max;
    }
}
