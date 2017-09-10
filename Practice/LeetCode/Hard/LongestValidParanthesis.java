class Solution {
    public static int longestValidParentheses(String s) {
	    int max = 0;
        int[] dp = new int[s.length()+1];
        for(int i=1;i<=s.length();i++){
            int j = i-2-dp[i-1];
            if(s.charAt(i-1) == '(' || j<0 || s.charAt(j) == ')')
                dp[i] = 0;
            else{
                dp[i] = dp[j]+2+dp[i-1];
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
--------------------
class Solution {
    public int longestValidParentheses(String s) {
      Stack<Integer> stack = new Stack<Integer>();
        int n = s.length();
        int longest = 0;
        int left = -1;
      for(int i=0;i<n;i++){
          char ch = s.charAt(i);
          if(ch == '(')
              stack.push(i);
          else{
              if(stack.isEmpty())
                  left = i;
              else{
                  stack.pop();
                  if(stack.isEmpty())
                      longest = Math.max(longest, i-left);
                  else
                      longest = Math.max(longest, i-stack.peek());
              }
          }
      }

        return longest;
    }
}
--------------------
public class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
-------------
class Solution {
    public static int longestValidParentheses(String s) {
	Stack<int[]> stack = new Stack<int[]>();
	int result = 0;

	for(int i=0; i<=s.length()-1; i++){
		char c = s.charAt(i);
		if(c=='('){
			int[] a = {i,0};
			stack.push(a);
		}else{
			if(stack.empty()||stack.peek()[1]==1){
				int[] a = {i,1};
				stack.push(a);
			}else{
				stack.pop();
				int currentLen=0;
				if(stack.empty()){
					currentLen = i+1;
				}else{
					currentLen = i-stack.peek()[0];
				}
				result = Math.max(result, currentLen);
			}
		}
	}

	return result;
}
}
