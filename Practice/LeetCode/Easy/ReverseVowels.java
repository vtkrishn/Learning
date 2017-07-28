public class Solution {
    public String reverseVowels(String s) {
        StringBuilder stb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isVowel(ch))
                stb.append(ch);
        }
        char[] ch = stb.reverse().toString().toCharArray();
        char[] c = s.toCharArray();
        int j = 0;
        for(int i=0;i<c.length;i++){
            if(isVowel(c[i]))
                c[i] = ch[j++];
        }
        return new String(c);
    }

    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
