public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] arr ={5,2,4,6,1,3};
	      insertionSort(arr);
	    }

	    public static void insertionSort(int[] a){
        for(int i=1;i<a.length;i++){
          int temp = 0;
          int j=0;
            while(j<i)	{
              if(a[j] > a[i]){
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
              }
            j++;
            }
        }
	    }
	}

	-----
	public static void main(String[] args){
		int[] arr = {11,34,0,7,55};//,64,93,22,31};
		int j = arr.length-1;
		int i=0;
		int temp;
		int inner=0;
		int outer=0;
		while(j>i){
				while(i<j){
						if(arr[i] > arr[j]){
						 temp = arr[i];
						 arr[i] = arr[j];
						 arr[j] = temp;
						}
						i++;
						++inner;
				}
				j--;
				i=0;
				++outer;
		}

		for(i=0;i<arr.length;i++){
				System.out.println(arr[i]);
		}

		System.out.println("inner ::" + inner);
		System.out.println("outer ::" + outer);
}

-------

public static void main(String[] args){
		int[] arr = {11,34,0,7,55,64,93,22,31};
		int j = 1;
		int i=0;
		int temp;
		int inner=0;
		int outer=0;
		while(i<j && i<arr.length){
				while(j<arr.length){
						if(arr[i] > arr[j]){
						 temp = arr[i];
						 arr[i] = arr[j];
						 arr[j] = temp;
						}
						j++;
						++inner;
				}
				i++;
				j=i+1;
				++outer;
		}

		for(i=0;i<arr.length;i++){
				System.out.println(arr[i]);
		}

		System.out.println("inner ::" + inner);
		System.out.println("outer ::" + outer);
}
