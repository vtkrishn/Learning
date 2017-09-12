public class YourClassNameHere {
    public static void main(String[] args) {
      int[] arr = {1,2,3,4,5,6,7,8};
      //search(arr,1);0
      //search(arr,8);7
      //search(arr,4);3
      //search(arr,5);4
    }

    public static int search(int[] arr,int k){
      int start = 0;
      int end = arr.length-1;
      while(start <= end){
        int mid = start + (end - start) / 2;
        if(arr[mid] ==k)
          return mid;
        else if(arr[mid] < k)
          start = mid + 1;
        else
          end = mid;
      }
      return -1;
    }
}
