public class YourClassNameHere {
    public static void main(String[] args) {
      int[] arr = {2, 3, 4, -1, -2, 1, 5, 6, 3};
      //int[] arr = {1, 0, 0, 1, -1, -1, 0, 0, 1, 0};
      System.out.println(findlongest(arr, 0,0,0));
    }

    public static int findlongest(int[] arr, int i,int maxSoFar,int current){
      if(i == arr.length)
        return maxSoFar;
      if(arr[i] >= 0){
        current = current + 1;
        maxSoFar = Math.max(maxSoFar, current);
      }
      else
        current = 0;
      return findlongest(arr,i+1,maxSoFar,current);
    }
}
