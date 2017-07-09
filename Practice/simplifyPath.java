public class Solution{
    public String simplifyPath(String path) {
            Deque<String> stack = new LinkedList<String>();
            String[] values = path.split("/");
            for(int i=0;i<values.length;i++){
                if(!values[i].equals(".") && !values[i].equals("..") && !values[i].equals("")){
                    stack.push(values[i]);
                }
                else if(values[i].equals("..") && stack.size() > 0){
                    stack.pop();
                }
            }
          String res = "";
          for(String s : stack)
            res = "/" + s + res;
          return res.isEmpty() ? "/" : res;
    }
}
