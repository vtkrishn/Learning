package javaproject.matrix;

public class NoOfPositionNotAccessible {
    public NoOfPositionNotAccessible() {
        super();
    }
    

    public static void main(String[] arg){
        //build the input matrix
        int[][] arr = buildMatrix();
        int row = arr.length;
        int col = arr[0].length;
        int[][] result = new int[row][col];
        //compute result
        for(int i=1;i<row-1;i++){
            for(int j=1;j<col-1;j++){
                //if(checkBoundary(i, j, row, col)){
                    int count=0;
                    //get all the neighbors count
                    for(int x=-1;x<=1;x++){
                        for(int y=-1;y<=1;y++){
                            count = count + arr[i+x][j+y];
                        }
                    }
                    count = count - arr[i][j];
                    if(arr[i][j] == 1 && (count > 3 || count < 2))
                            result[i][j] = 0;
                    else if(arr[i][j] == 0 && count == 3)
                        result[i][j] = 1;
                    else
                        result[i][j] = arr[i][j];
                //}
            }
        }
        //print the output matrix
        printMatrix(result,row,col);
    }
    private static boolean checkBoundary(int i, int j,int rowLength, int colLength){
        return (i >= 0 && i< rowLength) && (j >= 0 && j <colLength);
    }
    private static int[][] buildMatrix(){
        int[][] grid = { 
            { 0, 0, 0},
            { 0, 1, 0},
            { 0, 0, 0}
                };
        return grid;
    }
    private static void printMatrix(int[][] arr,int row, int col){
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(arr[i][j] + " ");
            }   
            System.out.println("");
        }
    }
}
