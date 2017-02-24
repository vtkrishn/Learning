https://community.topcoder.com/stat?c=problem_statement&pm=41
public class YourClassNameHere {
	    public static void main(String[] args) {
	      String str = "abc(def(ghi)";
	      System.out.println(isBalanced(str));
	    }

	    static boolean isBalanced(String input){
	      if(input == null)
	        return false;
	      Stack s = new Stack();

	      for(int i=0;i<input.length();i++){
	        char ch = input.charAt(i);
	       if(ch == '(' || ch == '[' || ch == '{'){
	         s.push(ch);
	       }

	       if(ch == ')' || ch == ']' || ch == '}'){
	         s.pop();
	       }
	      }

	      return s.isEmpty();
	    }
}
