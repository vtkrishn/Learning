public class YourClassNameHere {
    public static void main(String[] args) {
        int[] arr = {1,2,6,7};
        int k = 8;
        java.util.Map m = new java.util.HashMap();
        java.util.List l = new java.util.ArrayList();
        for(int i=0;i<arr.length;i++){
          int x = arr[i];
          if(m.containsKey(k-x))
            l.add("["+x+","+(k-x)+"]");
          else
            m.put(x,i);
        }
        System.out.println(l);

    }
}
