public class Solution {
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        return split.length > 0 ? split[split.length-1].length() : 0;
    }
}
