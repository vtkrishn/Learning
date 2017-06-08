import java.util.Stack;

public class Solution{

public static void main(String[] args){
	System.out.println(isBracketBalanced(""));
	System.out.println(isBracketBalanced("{"));
	System.out.println(isBracketBalanced("{<"));
	System.out.println(isBracketBalanced("{]"));
	System.out.println(isBracketBalanced("{[(<>)]}"));
	System.out.println(isBracketBalanced("{}[()<>"));
	System.out.println(isBracketBalanced("{}[()<>]"));
  System.out.println(isBracketBalanced("{(a)}"));
  System.out.println(isBracketBalanced("{(ab"));
    System.out.println(isBracketBalanced("(a)<html><>"));
    System.out.println(isBracketBalanced("}a>)html>"));
}

public static boolean isBracketBalanced(String brackets){
	if(brackets == null || brackets.equals(""))
		return false;

	Stack<Character> stack = new Stack<Character>();
	int i=brackets.length()-1;
	char c = ' ';
	char x = ' ';
	while(i>=0){
		c = brackets.charAt(i--);
		if(c == ']' || c == '}' || c == ')' || c == '>')
			stack.push(c);
		if(stack.size()>0){
		  x = stack.peek();
		  if((c == '{' &&  x == '}') || (c == '[' &&  x == ']') || (c == '(' &&  x == ')') || (c == '<' &&  x == '>'))
			  stack.pop();
		}else{
		  //leftover
		  stack.push(c);
		}

	}

	if(stack.isEmpty())
		return true;
	else
		return false;
}

}
------
public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}
-------------
public class YourClassNameHere {
    public static void main(String[] args) {
      bracket("{(a)b][c]}");
    }

    public static boolean bracket(String str){
      Stack<Character> stack = new Stack<Character>();
      for(int i=0;i<str.length();i++){
	char ch = str.charAt(i);
	if(ch == '[' || ch == '(' || ch == '{')
		stack.push(ch);
	else{
		if(ch == ']' || ch == ')' || ch == '}'){
			char peek = stack.peek();
			String concat = peek +""+ ch;
			if(concat.equals("[]") || concat.equals("()") || concat.equals("{}"))
				stack.pop();
			else
				return false;
		}
	}
}
return stack.isEmpty();
    }
}
