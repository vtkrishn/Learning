public class Solution {
    public boolean isHappy(int n) {
        int res = n;
        while (res >= 10) {
            n = res;
            res = 0;
            while (n > 0) {
                int digit = n % 10;
                res += digit * digit;
                n = n / 10;
            }
        }
        return res == 1 || res == 7;
    }
}
----------------
int digitSquareSum(int n) {
    int sum = 0, tmp;
    while (n) {
        tmp = n % 10;
        sum += tmp * tmp;
        n /= 10;
    }
    return sum;
}

bool isHappy(int n) {
    int slow, fast;
    slow = fast = n;
    do {
        slow = digitSquareSum(slow);
        fast = digitSquareSum(fast);
        fast = digitSquareSum(fast);
    } while(slow != fast);
    if (slow == 1) return 1;
    else return 0;
}

More...
