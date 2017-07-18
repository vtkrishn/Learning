public class Solution {
    public String reverseString(String s) {
        //TLE
        //if(s == null || s.equals(""))
        //    return "";
        //return s.charAt(s.length()-1) + reverseString(s.substring(0,s.length()-1));
        int start = 0;
        int end = s.length()-1;
        char[] ch = s.toCharArray();
        while(start < end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return new String(ch);
    }

}
