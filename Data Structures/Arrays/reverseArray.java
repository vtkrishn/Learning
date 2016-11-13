public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] m = {5,6,7,9,8};
	      reverse1(m);
	      reverse2(m);
	      reverse3(m,0);
	    }

	    public static void reverse1(int[] a)
      {
        if(a == null)
          return;

        int i=0;
        int j = a.length-1;
        int mid = i+j >>> 1;

        while(i<=mid){
          int temp = a[i];
          a[i] = a[j];
          a[j] = temp;
          i++;
          j--;
        }

      }

	    public static void reverse2(int[] a)
      {
        if(a == null)
          return;

        Stack<Integer> s = new Stack<Integer>();
        int i=0;
        while(i<a.length){
          s.push(a[i]);
          i++;
        }
        i=0;
        while(!s.isEmpty()){
          a[i++] = (Integer)s.pop();
        }

      }

      public static int reverse3(int[] a,int i)
      {
        if(a == null || i == a.length)
          return -1;

        int j = reverse3(a,i+1)+1;
        int temp = a[i];
          a[i] = a[j];
          a[j] = temp;
        return j;
      }
  }
