public class Pramp {
   public static void main(String[] args) {
      int[] arr =  {2, 4, 5, 9, 12, 17};
      findTheNum(arr,9);
      findTheNum(arr,12);
   }

   private static int findTheNum(int[] arr,int num){
      return findNumHelper(0, arr.length-1, arr, num);

   }

   private static int findNumHelper(int start, int end, int[] arr, int num){
      if(end >= start){
         int mid = (start + end)/2; // overflow
         if(num == arr[mid])
              return mid;
         else if(num > arr[mid])
              return findNumHelper(mid+1, end, arr, num);
         else
              return findNumHelper(start,mid-1, arr, num);
      }

      return -1;
   }

}
