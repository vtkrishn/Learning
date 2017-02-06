import java.util.*;
public class Solution{
	public static void main(String[] args){
		int[][] array = {
		{0,0,0,0},
		{0,1,0,0},
		{0,0,0,0},
		{0,0,0,0}
		};
		modifyArray(array);
	}
	private static void modifyArray(int[][] array){
		boolean firstRowZero = false;
		boolean firstColumnZero = false;
		for(int i=0;i<array.length;i++){
				if(array[i][0] == 1)
					firstColumnZero = true;
					break;
		}

		for(int i=0;i<array[0].length;i++){
				if(array[0][i] == 1)
					firstRowZero = true;
					break;
		}

		for(int i=1;i<array.length;i++){
			for(int j=1;j<array[0].length;j++){
				if(array[i][j] == 1){
					array[i][0] = 1;
					array[0][j] = 1;
				}
			}
		}

		for(int i=1;i<array.length;i++){
			for(int j=1;j<array[0].length;j++){
				if(array[i][0] == 1 || array[0][j] == 1){
					array[i][j] = 1;
				}
			}
		}

		if(firstRowZero){
			for(int i=0;i<array[0].length;i++){
				array[0][i] = 1;
			}
		}

		if(firstColumnZero){
			for(int i=0;i<array.length;i++){
				array[i][0] = 1;
			}
		}
   }
}
