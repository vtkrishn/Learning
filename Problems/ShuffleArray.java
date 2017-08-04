public class YourClassNameHere {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        for(int k=0;k<5;k++){
          int j = arr.length-1;
          for(int i=0;i<arr.length;i++){
            int rand = (int)(Math.random() * arr.length);
            int temp = arr[rand];
            arr[rand] = arr[j];
            arr[j] = temp;
            j--;
          }

          for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
          System.out.println("");
        }

    }
}
