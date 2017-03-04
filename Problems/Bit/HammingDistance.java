public class Solution {
    public int hammingDistance(int x, int y) {
        if(x == 0 && y == 0)
            return 0;
        int v = x ^y;

        // int c = v - ((v >> 1) & 0x55555555);
        // c = ((c >> 2) + c) & 0x33333333;
        // c = ((c >> 4) + c) & 0x0F0F0F0F;
        // c = ((c >> 8) + c) & 0x00FF00FF;
        // c = ((c >> 16) + c) &0x0000FFFF;

        int c = 0;
        for (c = 0; c<v; c++)
        {
            v &= v - 1;
        }

        return c;
    }
}
