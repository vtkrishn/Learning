public class Solution {
    public int[] constructRectangle(int area) {
		int width = (int)Math.sqrt(area),length = width;
		int[] result = new int[2];
        while(width >= 1){
				if(length * width == area)
					break;
				if(length * width < area)
					length++;
				else
					width--;
		}
		result[0] = length;
		result[1] = width;
		return result;
    }
}
