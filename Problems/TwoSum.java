import java.util.*;
public class ClassNameHere {
   public static void main(String[] args) {
      int[] arr = {7, 6, 3, 8, 1, 9};
      Arrays.sort(arr);
      int start = 0;
      int end = arr.length-1;
      int target = 15;
      while(start<end){
         int temp = arr[start]+arr[end];
         if(temp == target){
            System.out.println(arr[start] +" "+ arr[end]);
            break;
         }
         else if(temp < target){
            start++;
         }
         else{
            end--;
         }
      }
   }
}
