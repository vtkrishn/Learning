public class Solution {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int i=0;
        int n = charArray.length;
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            reverse(charArray, i, j);
            i += 2 * k;
        }
        return new String(charArray);
    }

    public void reverse(char[] charArrray, int start,int end){
        while(start < end){
            char temp = charArrray[start];
            charArrray[start++] = charArrray[end];
            charArrray[end--] = temp;
        }
    }

}
