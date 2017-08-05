package javaproject.array;

import java.util.Arrays;

public class SearchInsDel {
    public SearchInsDel() {
        super();
    }
    
    public static void main(String[ ]args){
        int[] arr = {1,2,3,4,5};
        int i, temp;
          temp = arr[0];
          for (i = 0; i < arr.length-1; i++)
             arr[i] = arr[i+1];
          arr[i] = temp;
        Arrays.stream(arr).forEach(System.out::println);
    }
}
