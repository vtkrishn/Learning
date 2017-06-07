public class YourClassNameHere {
    public static void main(String[] args) {
      //int arr[] = {3,4,0,2};
      int arr[] = {3,5,4,-1,5,1,-1};
        int i=0;
        while(i<arr.length){
          int value = arr[i];
          if(value > 0 && value <= arr.length && value != arr[value-1]){
            swap(arr, i,value-1);
          }
          else{
           i++;
          }
        }

        for(i=0;i<arr.length;i++){
          if(arr[i] != i+1){
            System.out.println(i+1);
            break;
          }
        }
    }

    private static void swap(int[] a, int start, int end){
      int temp = a[start];
      a[start] = a[end];
      a[end] = temp;
    }
}
