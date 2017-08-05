package javaproject;

public class permute {
    public permute() {
        super();
    }
    
    public static void main(String[] args){
        String s = "hot";
        int length = s.length();
        boolean[] visited = new boolean[length];
        char[] ch = s.toCharArray();
        char[] branch = new char[length];
        dfs(ch,branch,visited,length,-1);
    }
        
    private static void dfs(char[] ch, char[] branch,boolean[] visited,int length, int level){
        if(level >= length-1){
            System.out.println(branch);
            return;
        }
            
        for(int i=0;i<length;i++){
            if (!visited[i]){
                branch[++level] = ch[i];
                visited[i] = true;
                dfs(ch, branch, visited, length, level);
                visited[i] = false;
                level--;
            }
        }
    }
        
}
