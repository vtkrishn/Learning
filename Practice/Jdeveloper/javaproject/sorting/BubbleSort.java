package javaproject.sorting;

public class BubbleSort {
    public BubbleSort() {
        super();
    }
    
    public static void main(String[] args){
        int[] arr = {5,64,73,12,1};
        boolean swapped = true;
        int pass = 0;
        long startTime = System.nanoTime();
        while(swapped){
            System.out.println("Outer pass");
            swapped =false;
            //for(int i=1;i<arr.length;i++){ // not-optimized
            for(int i=1;i<arr.length-pass;i++){ // optimized , omit already sorted elements
                System.out.println("Inner loop");
                if(arr[i-1] > arr[i]){
                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            pass++;
        }
        long endTime = System.nanoTime();
        int j = 0;
        while(j<arr.length){
            System.out.println(arr[j]);
            j++;                    
        }
        System.out.println("Time taken :: " + (endTime - startTime)/1000 + " ms"); 
    }
}
