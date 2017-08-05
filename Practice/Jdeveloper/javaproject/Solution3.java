package javaproject;

public class Solution3{

  public static void main(String[] args){
    int[][] imageArray= {
                        {0,0,1,0},
                        {0,1,1,0},
                        {0,1,0,0}    
                        };
    findMinArea(imageArray);
  }

  public static int findMinArea(int[][] imageArray){
    if(imageArray == null || imageArray.length == 0)
      return 0;

    int row = imageArray.length;
    int col = imageArray[0].length;

    int lengthRow=0;
    int lengthCol=0;
    // for(int i=0;i<row;i++){
    //   for(int j =0;j<col;j++){
    //     if(imageArray[i][j] == 1){
    //       lengthRow++;
    //       break;
    //     }
    //   }
    // }

    // for(int i=0;i<col;i++){
    //   for(int j =0;j<row;j++){
    //     if(imageArray[j][i] == 1){
    //       lengthCol++;
    //       break;
    //     }
    //   }
    // }
    int y = helper(imageArray, 0 ,0,row,col);
    return lengthRow * lengthCol;  
  }
  
  public static int helper(int[][] imageArray,int i, int j,int m,int n){
    if(i>=m || j >=n)
      return 0;
    if(imageArray[i][j] == 1)
        return 1 + helper(imageArray,i+1,j,m,n) * helper(imageArray,i,j+1,m,n);
    return helper(imageArray,i+1,j,m,n) * helper(imageArray,i,j+1,m,n);  
    //helper(imageArray,i-1,j,m,n);  
    //helper(imageArray,i,j-1,m,n);
}
}
