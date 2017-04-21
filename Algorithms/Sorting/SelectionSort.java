package javaproject.sorting;

public class SelectionSort {
    public SelectionSort() {
        super();
    }
    public static void main(String[] args){
        int[] arr = {5,14,23,122,11};
        long startTime = System.nanoTime();
        int min = 0,temp = 0;
        for(int i=0;i<arr.length-1;i++){
            System.out.println("Outer pass");
            min = i;
            for(int j=i+1;j<arr.length;j++){
                System.out.println("Inner loop");
                if(arr[j] < arr[i]){
                    min = j;
                }
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }

        int k=0;
        long endTime = System.nanoTime();
        while(k<arr.length){
            System.out.println(arr[k]);
            k++;
        }
        System.out.println("Time taken :: " + (endTime - startTime)/1000 + " ms");
    }
}
