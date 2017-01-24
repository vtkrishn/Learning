public class Solution {
    public int hammingDistance(int x, int y) {
        int m = x ^ y;
        int count = 0;
        while(m != 0){
            int temp = m & 1;
            if(temp == 1)
                count++;
            m = m >> 1;
        }
        return count;
    }
}
