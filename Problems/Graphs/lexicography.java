public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=9;i++){
            dfs(i,n,list);
        }
        return list;
    }

    public static void dfs(int val,int n, List<Integer> list){
        if(val > n)
            return;
        list.add(val);
        for(int i=0;i<=9;i++){
            dfs(val*10+i,n,list);
        }
    }

}
