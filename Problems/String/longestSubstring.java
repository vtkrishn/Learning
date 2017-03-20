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
