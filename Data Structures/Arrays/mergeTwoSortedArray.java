public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] m = {5,6,7,9};
	      int[] n = {1,2,3,11,15};
	      merge(m,n);
	    }

	    public static int[] merge(int[] m,int[] n)
      {
          if(m == null)
            return n;

          if(n == null)
            return m;

          int[] merged = new int[m.length + n.length];
          int i=0;
          int j = 0;
          int k=0;
          while(i<m.length && j<n.length){
            if(m[i] < n[j]){
              merged[k] = m[i];
              i++;
              k++;
            }
            else{
             merged[k] = n[j];
              j++;
              k++;
            }
          }

          while(i<m.length){
            merged[k] = m[i];
            k++;
            i++;
          }

          while(j<n.length){
            merged[k] = n[j];
            k++;
            j++;
          }

          return merged;
      }
  }
