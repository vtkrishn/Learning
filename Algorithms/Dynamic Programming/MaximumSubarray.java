public class YourClassNameHere {
    public static void main(String[] args) {
      int[] a = {904,40,523,12,-335,-385,-124,1481,-31};
        int minIndex = -1, minSum = 0, sum=0,maxSum = 0;
        int start = 0,end = 0;

        for(int i=0;i<a.length;i++){
          sum = sum + a[i];
          if(sum < maxSum){
            minSum = sum;
            minIndex = i;
          }

          if(sum-minSum > maxSum){
            maxSum =  sum-minSum;
            start = minIndex+1;
            end = i+1;
          }
        }
}
}

--------
public class YourClassNameHere {
    public static void main(String[] args) {
      //int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
      //int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
      int[] a = {904,40,523,12,-335,-385,-124,1481,-31};
      int currentMax = a[0];
      int max = a[0];
      int start = 0,end = 0;
      for(int i=1;i<a.length;i++){
        currentMax = currentMax + a[i];
        if(currentMax < 0){
         currentMax = 0;
         start = i+1;
        }
        if(currentMax > max){
          max = currentMax;
          end = i;
        }
      }
    }
}
