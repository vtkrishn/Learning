public class Solution{
	public static void main(String[] args){
		int[][] array = {
		{10,20,30,40},
		{14,24,34,44},
		{18,28,38,48},
		{21,32,43,50}
		};

		search1(array, 4, 38);
	}

	private static boolean search(int[][] array , int length, int search){
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				if(array[i][j] == search)
					return true;
			}
		}
		return false;
	}

	private static boolean search1(int[][] array , int length, int search){
		int i = 0;
		int j = length-1;

		while(i<length && j >= 0){
			if(array[i][j] == search)
				return true;
			else if(array[i][j] > search)
				j--;
			else if(array[i][j] < search)
				i++;
		}
		return false;
	}

}
