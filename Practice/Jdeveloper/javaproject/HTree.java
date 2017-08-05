package javaproject;

public class HTree {
    public HTree() {
        super();
    }
    
    public static void main(String[] args){
        int[][] arr = 
            {
            {0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0}
            };
        drawHTree(arr, 4,4,2);
        printArr(arr);
    }
    
    private static void printArr(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
    private static void drawHTree(int[][] arr,int x,int y, int length){
        int x1 = x+length;
        int y1 = y+length;
        
        drawLine(arr, x, y, x1, y1);
    }
    private static void drawLine(int[][] arr, int x1,int y1, int x2, int y2){
        for(int i=x1;i<x2;i++){
            for(int j=y1;j<y2;j++){
                    arr[i][j] = 1;
        }
    }
    }
}
