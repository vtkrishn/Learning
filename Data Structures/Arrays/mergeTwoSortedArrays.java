public class YourClassNameHere {
	    public static void main(String[] args) {
	     int[] a= {1,3,5,7,9,0,0,0,0,0,0};
	     int[] b= {2,4,6,8};

	     merge(a,b,5);

	    }

	    public static void merge(int[] a, int[] b, int x){
	      int m = a.length;
	      int n = b.length;
	      int i=0;
	      int j=0;

	     // while(i<m && j<n){
	     //   a[x+i] = b[j];
	     //   i++;
	     //   j++;
	     // }

	     //java.util.Arrays.sort(a);

	     //while(a[i] != 0 && i<m && j<n){
	     //   if(b[j] < a[i]){
	     //     int temp = b[j];
	     //     b[j] = a[i];
	     //     a[i] = temp;
	     //   }

	     //   if(b[j] > b[j+1]){
	     //       int temp = b[j];
	     //       b[j] = b[j+1];
	     //       b[j+1] = temp;
	     //    }

      //     i++;
	     //}

	     //java.util.Arrays.sort(b);

      //     i=x;
      //     j=0;
      //   while(i<m && j<n){
	     //   a[i] = b[j];
	     //   i++;
	     //   j++;
	     //}


	     i=x-1;
	     j=n-1;
	     int k = x+n-1;
	     while(i>=0 && j>=0){
	       if(b[j] > a[i]){
	        a[k] = b[j];
	        j--;
	       }
	       else{
	        a[k] = a[i];
	        i--;
	       }
	       k--;
	     }


	    }


	}
