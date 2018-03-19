20
Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Convert the string to character array
add the character to the stack if its a start bracket
if there is a subsequent close bracket and if the top element is either of "{" or "(" or "["  then pop and chk if the element+pop forms "{}" or "()" or "[]"
if stack is empty then return true otherwise continue

Solution

public class Solution {
                public boolean isValid(String s) {
                        char[] str = s.toCharArray();
                        Stack stack = new Stack();
                        for(int i=0;i<str.length;i++){
                            if(str[i] == '}' || str[i] == ']' || str[i] == ')'){
                                if(!stack.isEmpty()){
                                    char c = (Character)stack.peek();
                                    if(c == '{' || c == '(' || c == '['){
                                        char cPop = (Character)stack.pop();
                                        String k = ""+cPop+str[i];
                                        if(k.equals("{}") || k.equals("[]") || k.equals("()")){
                                            if(stack.isEmpty()  && i == str.length-1)
                                                return true;
                                        }
                                        else{
                                            return false;
                                        }
                                    }
                                }
                            }
                            else{
                                stack.push(str[i]);
                            }
                        }
                        return false;
        }
}
