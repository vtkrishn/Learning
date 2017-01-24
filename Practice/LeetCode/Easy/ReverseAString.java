public class Solution {
    public String reverseString(String s) {
        if(s == null || s.equals(""))
            return s;
        int j=s.length()-1;
        char[] ch = s.toCharArray();
        StringBuilder stb = new StringBuilder();
        for(int i=0;i<s.length()/2;i++){
            char temp = ch[j];
            ch[j] = ch[i];
            ch[i] = temp;
            j--;
        }

        for(int i=0;i<ch.length;i++){
            stb.append(ch[i]);
        }
        return stb.toString();
    }
}
----------------
public class Solution {
    public String reverseString(String s) {
        Stack stk = new Stack();
        for(int i=0;i<s.length();i++){
            stk.push(s.charAt(i));
        }
        StringBuilder stb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            stb.append(stk.pop());
        }
        return stb.toString();
    }
}
--------------------
public class Solution {
    public String reverseString(String s) {
        StringBuilder stb = new StringBuilder(s);
        return stb.reverse().toString();
    }
}
-------------
public class Solution {
    public String reverseString(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }
}
