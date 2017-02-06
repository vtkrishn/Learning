public class Pramp {
   public static void main(String[] args) {
      int[][] array = {
         {1,  2,   3,   4,  5},
         {6,  7,   8,   9,  10},
         {11, 12,  13,  14, 15},
         {16, 17,  18,  19, 20}
      };

      printSpiral(array);
   }


   private static void printSpiral(int[][] array){
      int rowLength = array.length;
      int colLength = array[0].length;

      int top=0;
      int left=0;
      int right=colLength-1;
      int down=rowLength-1;

      while(top <= down && left <= right){

       for(int i=left;i<=right;i++){
          System.out.println(array[top][i] + " ");
       }
       top++;

       for(int i=top;i<=down;i++){
          System.out.println(array[i][right] + " ");
       }
       right--;

       for(int i=right;i>=left;i--){
          System.out.println(array[down][i] + " ");
       }
       down--;

       for(int i=down;i>=top;i--){
          System.out.println(array[i][left] + " ");
       }
       left++;
      }
  }

}
--------------
public class Solution{
	public static void main(String[] args){
		int[][] array = {
		{10,20,30,40},
		{14,24,34,44},
		{18,28,38,48},
		{21,32,43,50}
		};

		printSpiral(array);
	}

	private static void printSpiral(int[][] array){
		int top = 0;
		int left = 0;
		int right = array[0].length  -1;
		int down = array.length - 1;
		while(top <= down && left <= right){
			for(int i=left; i<=right;i++){
				System.out.println(array[top][i]);
			}
			top++;
			for(int i=top; i<=down;i++){
				System.out.println(array[i][right]);
			}
			right--;
			for(int i=right; i>=left;i--){
				System.out.println(array[down][i]);
			}
		  down--;
			for(int i=down; i>=top;i--){
				System.out.println(array[i][left]);
			}
		  left++;
		}
	}
}
