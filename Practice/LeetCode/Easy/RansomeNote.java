public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for(int i=0;i<magazine.length();i++)
            map[magazine.charAt(i)-'a']++;
        for(int i=0;i<ransomNote.length();i++){
            if(map[ransomNote.charAt(i)-'a'] > 0)
                map[ransomNote.charAt(i)-'a']--;
            else
                return false;
        }
        return true;
    }
}
