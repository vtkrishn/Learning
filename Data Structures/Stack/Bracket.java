public class Solution{

public static void main(String[] args){
	System.out.println(isBracketBalanced(""));
	System.out.println(isBracketBalanced("{"));
	System.out.println(isBracketBalanced("{<"));
	System.out.println(isBracketBalanced("{]"));
	System.out.println(isBracketBalanced("{[(<>)]}"));
	System.out.println(isBracketBalanced("{}[()<>"));
	System.out.println(isBracketBalanced("{}[()<>]"));
}

public static boolean isBracketBalanced(String brackets){
	if(brackets == null || brackets.equals(""))
		return false;

	Stack<Character> stack = new Stack<Character>();
	int i=brackets.length()-1;
	char c = ' ';
	char x = ' ';
	boolean flag = false;
	while(i>=0){
		c = brackets.charAt(i--);
		if(c == ']' || c == '}' || c == ')' || c == '>')
			stack.push(c);
		if(stack.size()>0){
		  x = (char)stack.peek();
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
