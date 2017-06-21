public class Solution11 {
    public Solution11() {
        super();
    }
    static Set<List> set = new HashSet<List>();
    public static void main(String[] args){
        int[] arr = {-5,1,10,2,3};
        for(int i=0;i<arr.length;i++){
            findSet(arr,i);
        }

        System.out.println(set.toString());
    }

    public static void findSet(int[] arr, int i){
        for(int j=0;j<arr.length;j++){
            List<Integer> list = new ArrayList<Integer>();
            list.add(arr[i]);
            list.add(arr[j]);
            int output = findSet2(arr,i,j,list, arr[i]+arr[j]);
            if(output != 0){
                list.add(output);
                Collections.sort(list);
                set.add(list);
            }
        }
    }

    public static int findSet2(int[] arr, int i, int j, List<Integer> list,int sum){
        return (j == arr.length) ? 0 : ((sum + arr[j] == 0) ? arr[j] : findSet2(arr,i,j+1,list,sum));
    }
}
