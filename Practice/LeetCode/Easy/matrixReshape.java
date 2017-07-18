public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int numsRow = nums.length;
	int numsCol = nums[0].length;

	if((numsRow * numsCol) != (r * c))
		return nums;

	int[][] result = new int[r][c];
	int m=0;
	int n=0;
	for(int i=0;i<numsRow;i++){
  		for(int j=0;j<numsCol;j++){
  		  if(n == c){
  		    n=0;
  		    m++;
  		  }
  		  result[m][n] = nums[i][j];
  		   n++;
  		}
		}
	return result;
    }
}
