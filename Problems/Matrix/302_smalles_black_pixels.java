public class Solution{

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
    for(int i=0;i<row;i++){
      for(int j =0;j<col;j++){
        if(imageArray[i][j] == 1){
           lengthRow++;
           break;
        }
      }
    }

    for(int i=0;i<col;i++){
      for(int j =0;j<row;j++){
        if(imageArray[j][i] == 1){
           lengthCol++;
           break;
        }
      }
    }

    return lengthRow * lengthCol;
  }
}
----------------------------------
