package javaproject;

public class SumMatrix{
	public static void main(String[] args){
		int[][] array = {
		{1,0,1,0},
		{1,1,0,0},
		{1,0,1,0},
		{0,1,1,1}
		};
		maxSubArray(array);
	}

        private static int min(int x, int y, int z){
            int temp = x;
            if(temp < y)
                temp = y;
            if(temp < z)
                temp = z;
            
            return temp;
        }
	private static void maxSubArray(int[][] array){
		int row = array.length;
		int column = array[0].length;
		
		int s[][] = new int[row][column];
		
		for(int i=0;i<row;i++){
			s[i][0] = array[i][0];
		}
		
		for(int i=0;i<column;i++){
			s[0][i] = array[0][i];
		}
		
		for(int i=1;i<row;i++){
			for(int j=1;j<column;j++){
				if(array[i][j] == 1)
					s[i][j] = min(array[i-1][j],array[i][j-1],array[i-1][j-1]) + 1;
				else
					s[i][j] = 0;
			}
		}
		
		int max_of_s = s[0][0]; 
		int max_i = 0; 
		int max_j = 0;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
			  if(max_of_s < s[i][j]){
				 max_of_s = s[i][j];
				 max_i = i; 
				 max_j = j;
			  }        
			}                 
		}
                
       for(int i = max_i; i > max_i - max_of_s; i--){
           for(int j = max_j; j > max_j - max_of_s; j--){
             System.out.print(array[i][j] + " ");
           } 
             System.out.println("");
         }  
		
   }
}