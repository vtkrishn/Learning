
public class MedianOfSortedArray {
	
	public static void main(String[] args) {
		int[] array1 = {1,2,3,4,5};
		int[] array2 = {6,7,8,9,10};
//		System.out.println(binarySearch(array, 1));
//		System.out.println(binarySearch(array, 7));
//		System.out.println(binarySearch(array, 3));
//		System.out.println(binarySearch(array, 45));
		
		System.out.println(findMedian(array1, array2));
		
	}
	
	
	private static int findMedian(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		
		int k = m+n; // 8
		if(k%2 == 0) //even
			findMedian(0,k/2-1,k/2,k,a,b);
		else // odd	
			findMedian(0, k/2,k/2+1, k,a,b);
		return 0;
	}
	
	private static int findMedian(int start, int midstart, int midend, int end, int[] a, int[] b) {
		
	}
	
	private static int binarySearch(int[] array, int target) {
		int start = 0;
		int end = array.length-1;
		
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(target == array[mid])
				return mid;
			
			if(target < array[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	
	}
}
