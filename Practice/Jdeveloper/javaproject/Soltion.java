package javaproject;

public class Soltion{
	public static void main(String[] args){
		int[] array = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
		findMaxSum(array,2);
	}
	
	public static void findMaxSum(int[] array,int m){	
		int length = array.length;
		int sum = 0;
		int maxSum = 0;
		int start = 0;
		int zeroCount = 0;
		int zeroStart = 0;
		while(start < length){
			while(zeroCount <= m){
				if(array[start] == 1)			
					sum = sum + array[start];
				else{
					if(zeroCount == 0)
					  zeroStart = start;
					zeroCount++;
				}
				
				start++;			
			}
			maxSum = Math.max(maxSum,sum);
			sum = 0;
			start = zeroStart;
                        zeroCount = 0;
		}
	}
}
