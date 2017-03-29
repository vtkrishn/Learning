public class Solution {
        public static int lengthOfLongestSubstring(String s) {
        int[] dict = new int[256];
        for(int i=0;i<256;i++)
            dict[i] = -1;
        int maxLen = 0, start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (dict[s.charAt(i)] > start)
                start = dict[s.charAt(i)];
            dict[s.charAt(i)] = i;
            maxLen = Math.max(maxLen, i - start);
        }
        return maxLen;
        }
}


-----------
public class YourClassNameHere {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int j=0;
        int max=0;
        int[] count = new int[256];
        for(int i=0;i<str.length();i++){
          char ch = str.charAt(i);
          if(count[ch] == 0){
            count[ch]++;
            j++;
          }
          else{
            max = Math.max(max,j);
            j=0;
          }
        }
        max = Math.max(max,j);
    }
}
