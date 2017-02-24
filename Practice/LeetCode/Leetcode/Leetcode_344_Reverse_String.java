public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() == 1)
            return s;
        
        //method 1
        char[] c = s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<s.length()/2 && i<j){
            while(j>i){
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                
                i++;
                j--;
            }
        }
        
        //method 2
        // Stack<Character> stack = new Stack<Character>();
        // for(int i=0;i<s.length();i++){
        //     stack.push(s.charAt(i));
        // }
        
        // char[] c = new char[s.length()];
        // for(int i=0;i<s.length();i++){
        //     c[i] = stack.pop();
        // }
        
        return new String(c);
    }
}
