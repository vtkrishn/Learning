public class YourClassNameHere {
    public static void main(String[] args) {
      int[] arr = {3,4,1,-1,5,-1};
      findMissingNumber(arr);
    }

    public static int findMissingNumber(int[] arr){
        int j = 0;
        for(int i=0;i<arr.length;i++){
          int temp = arr[j];
          if(temp > arr[temp-1]){
            arr[j] = arr[temp-1];
            arr[temp-1] = temp;
          }
          j++;
        }
        return arr[j];
    }
}
