public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] mn = {2,3,0,9,14,0,0,0,21};
	      moveToEnd(mn);
	    }

	    public static void moveToEnd(int[] mn)
      {
        int j = mn.length - 1;
        for (int i = mn.length - 1; i >= 0; i--)
        {
            if (mn[i] != 0)
            {
                mn[j] = mn[i];
                j--;
            }
        }
    }
  }
  http://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
