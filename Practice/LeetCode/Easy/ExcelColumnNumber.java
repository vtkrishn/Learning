public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i)-'A';
            sum = sum * 26 + (ch + 1);
        }
        return sum;
    }
}
