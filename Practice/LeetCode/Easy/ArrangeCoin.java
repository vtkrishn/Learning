class Solution {
    public int arrangeCoins(int n) {
        int i=0;
        while(i <= n){
            n = n - i;
            i++;
        }
        return i-1;
    }
}
