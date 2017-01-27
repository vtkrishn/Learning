public class Pramp{

	public static void main(String[] args){
		int[] arr = {56,78,98,2,11,34};
		System.out.println(findTheIndexofNumber(arr,34));
	}

	private static int findTheIndexofNumber(int[] arr, int num){
		int j=0;
		int dip = 0;
		for(int i=1;i<arr.length;i++){
			if(arr[j] > arr[i])
				dip = j;
		  j++;
		}

		int x = search(dip + 1,arr.length-1, arr,num);
		return x == -1 ? search(0,dip, arr,num) : x;
	}

	private static int search(int start, int end, int[] arr,int num){
		int mid = start + (end - start)/2;

		if(end < start)
		  return -1;

		if(num == arr[mid])
			return mid;
		else if(num > arr[mid])
			return search(mid+1,arr.length-1,arr,num);
		else
			return search(start,mid-1,arr,num);
	}
}
