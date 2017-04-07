import java.util.*;

public class YourClassNameHere {
    public static void main(String[] args) {
      int[] arr = {1,-2,-3,4,5,6,-7};
      findZeroNumbers(arr);
    }

    public static void findZeroNumbers(int[] arr){
      Set set = new HashSet();
      for(int i=0;i<arr.length;i++){
        if(!set.contains(arr[i]) && arr[i] < 0)
          set.add(arr[i]);
      }

      int temp;
      for(int i=0;i<arr.length;i++){
        for(int j=i+1;j<arr.length;j++){
          temp = arr[i] + arr[j];
          if(set.contains(-temp))
            System.out.println(arr[i] +"+"+arr[j]+""+ (-temp));
      }
    }
    }
}
