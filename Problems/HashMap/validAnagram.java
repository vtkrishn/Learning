public class Solution {
        public boolean isAnagram(String s, String t) {
            int[] sourceChar = new int[26];
            int i;
            for(i=0;i<s.length();i++)sourceChar[s.charAt(i)-'a']++;
            for(i=0;i<t.length();i++)sourceChar[t.charAt(i)-'a']--;
            for(i=0;i<sourceChar.length;i++) if(sourceChar[i] != 0) return false;
            return true;
    }
}
