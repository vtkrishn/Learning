public class YourClassNameHere {
    public static void main(String[] args) {
      int[][] matrix = {
        {1,1,2},
        {2,4,5},
        {6,9,1}
      };

      System.out.println(findMaxPathLength(matrix,0,0));
    }

    public static int findMaxPathLength(int[][] matrix,int i,int j){
        if(i>=matrix.length || j >= matrix[0].length)
          return 0;
        return matrix[i][j] + Math.max(findMaxPathLength(matrix,i,j+1),findMaxPathLength(matrix,i+1,j));
    }
}
