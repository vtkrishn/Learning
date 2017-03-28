public class YourClassNameHere {
    public static void main(String[] args) {
    int[] a = {1,2,3,4,5,6,7,56};
    findMaxMin(a);
    }

    private static void findMaxMin(int[] array){
		  int length = array.length;
		  int x = 0;
		  int j = 0;
		  boolean flag = true;
		  int run = 0;
		  while(run<length){
		    if(!flag)
		      j = x++;
		    else
		      j= length - (x + 1);

		    System.out.println(array[j]);
		    flag = !flag;
		    run++;
		  }
	  }
}
