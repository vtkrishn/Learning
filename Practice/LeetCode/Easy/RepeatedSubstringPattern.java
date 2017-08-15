public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() <=1) return false;
        String s2 = s+s;
        s2 = s2.substring(1,s2.length()-1);
        if(!s2.contains(s)) return false;
        return true;
    }
}
