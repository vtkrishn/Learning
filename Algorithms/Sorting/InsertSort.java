package javaproject.sorting;

public class InsertionSort {
    public InsertionSort() {
        super();
    }

    public static void main(String[] args){
        int[] arr = {5,14,23,122,11};
        long startTime = System.nanoTime();

        int j=0;
        for(int i=1;i<arr.length;i++){
            System.out.println("Outer pass");
            j=0;
            while(j<i){
                System.out.println("Inner loop");
                if(arr[j] > arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                j++;
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
