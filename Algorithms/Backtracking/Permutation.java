// permute from A to C
// ABC swap A-A
// 	ABC permute from B to C
// 		ABC swap B-B
// 			print ABC
// 		ABC swap B-C
// 			print ACB
//
// permute from B to C
// ABC swap B-A
// 	BAC permute from A to C
// 		BAC swap A-A
// 			print BAC
// 		BAC swap A-C
// 			print BCA
//
// permute from C to C
// ABC swap C-A
// 	CBA permute from C to C
// 		CBA swap C-C
// 			print CBA
// 		CBA swap B-A
// 			print CAB


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
