import java.io.*;
import java.util.*;

class Solution {

  static int shiftedArrSearch(int[] shiftArr, int num) {
    int i = 0;
    if(shiftArr.length == 1)
      return 0;

    while(i+1 < shiftArr.length && shiftArr[i+1] > shiftArr[i])
      i++;

    if(i == shiftArr.length)
      i--;

    if(num == shiftArr[i])
      return i;
    else if(i+1 < shiftArr.length && num > shiftArr[i+1]){ //number is in right partition
      return binarySearch(i+1,shiftArr.length-1,shiftArr,num);
    }
    else{ // number is in left partition
      return binarySearch(0,i,shiftArr, num);
    }
  }
  public static int binarySearch(int start, int end , int[] arr, int num){
    while(start <= end){
      int mid = start + (end - start)/2;
      if(arr[mid] == num)
          return mid;
      else if(arr[mid] < num)
        start = mid + 1;
      else
        end = mid-1;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {9,12,17,2,4,5};
    System.out.println(shiftedArrSearch(arr, 2));
  }

}
