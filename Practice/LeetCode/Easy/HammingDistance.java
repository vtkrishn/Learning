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

------

public class Solution {
    public int hammingDistance(int x, int y) {
        int m = x ^ y;
        int count = 0;
        while(m != 0){
            m = m & (m-1);
            count++;
        }
        return count;
    }
}

-------

http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/lang/Integer.java#Integer.bitCount%28int%29

public class Solution {
    public int hammingDistance(int x, int y) {
        int i = x ^ y;
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
        //return Integer.bitCount(x ^ y);
    }
}
