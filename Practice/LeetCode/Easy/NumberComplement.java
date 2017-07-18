public class Solution {
    public int findComplement(int num) {
     return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
----------
int mask = 1;
        while(mask <= num){
          num = num ^ mask;
          mask = mask<<1;
        }
       return num < 0 ? num+1 : num;  
