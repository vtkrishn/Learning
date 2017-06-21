public class YourClassNameHere {
    public static void main(String[] args) {
      int[] a = {904,40,523,12,-335,-385,-124,1481,-31};
      int[] sum = new int[a.length];
      sum[0] = a[0];
      for(int i=1;i<a.length;i++){
        sum[i] = sum[i-1] + a[i];
      }
      //range a[i,j] = sum[j] - sum[i-1];
      //a[7,8]
      System.out.println(sum[8]-sum[6]);
    }
}
