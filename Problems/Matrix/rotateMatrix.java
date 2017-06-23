public class Main{
  public static void main(String[] args){
    int[][] mat = {
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,16},

    };
    for(int i=0;i<mat.length;i++){
        for(int j=0;j<mat[0].length;j++){
            if(i>j){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    for(int i=0;i<mat.length;i++){
        int j = mat.length-1;
        int k = 0;
        while(k<j){
            int temp = mat[i][k];
            mat[i][k] = mat[i][j];
            mat[i][j] = temp;
            k++;
            j--;
        }
    }

    for(int i=0;i<mat.length;i++){
        for(int j=0;j<mat[0].length;j++){
            System.out.print(mat[i][j]+" ");
        }
        System.out.println("");
    }
  }

}
