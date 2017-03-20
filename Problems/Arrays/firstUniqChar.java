public class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            count[c]++;
        }
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (count[c] == 1) {
                return i;
            }
        }
        return -1;
    }
}
