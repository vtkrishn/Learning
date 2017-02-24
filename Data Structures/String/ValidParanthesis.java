public class YourClassNameHere {
	    public static void main(String[] args) {
	      String str = "(A+B)";
	      
	      java.util.Stack s = new java.util.Stack();
	      char[] ch = str.toCharArray();
	      boolean flag = false;
	      
	      for(int i=0;i<ch.length;i++){
	        if(ch[i] == '(' || ch[i] == '+' || ch[i] == '-'){
	          s.push(ch[i]); 
	        }
	       
	        if(ch[i] == ')'){
	         while(true){
	           char chk = (Character)s.pop();
	           if(chk == '+' || chk == '-')
	              flag = true;
	              
	           if(chk == '(')
	              break;
	         }
	        }
	      }
	      
	      if(s.isEmpty() && flag)
	        System.out.println(true);
	      
	      
	    }
	}
