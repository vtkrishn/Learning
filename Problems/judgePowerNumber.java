public class YourClassNameHere {
    public static void main(String[] args) {
      System.out.println(judgeNumber1(45));
    }

    public class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0;
      int right = (int)Math.sqrt(c);
      int sum = 1;
      while(left<=right){
        sum = left*left + right*right;
        if(sum > c)
          right--;
        else if(sum < c)
          left ++;
        else
          return true;
      }
      return false;
    }

}
