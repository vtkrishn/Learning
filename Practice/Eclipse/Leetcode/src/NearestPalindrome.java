
public class NearestPalindrome {

	
	public static void main(String[] args) {
		long input = 156789;
		findNearestPalindrome(input);
	}
	
	private static long findNearestPalindrome(long input){
			String str = String.valueOf(input);
			int len = str.length();
			int mid = len % 2 == 0 ? len/2 : (int)Math.floor(len/2);
			int offSet = Integer.valueOf(str.substring(mid)).intValue();
			long min = Integer.MAX_VALUE;
			for(long i=input-offSet;i<input+offSet;i++) {
				if(isPalindrome(i)) {
					min = Math.min(min, Math.abs(i));
				}
			}
			System.out.println(min);
		return min;
	}
	
	private static boolean isPalindrome(long input) {
		String str = String.valueOf(input);
		int start = 0;
		int end = str.length()-1;
		while(start<=end) {
			if(str.charAt(start++) != str.charAt(end--))
				return false;
		}
		return true;
	}
}
