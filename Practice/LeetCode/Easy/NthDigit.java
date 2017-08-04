public int findNthDigit(int n) {
    n -= 1;
    int digits = 1, first = 1;
    while (n / 9 / first / digits >= 1) {
        n -= 9 * first * digits;
        digits++;
        first *= 10;
    }
    return (first + n/digits + "").charAt(n%digits) - '0';
}
----------
public int findNthDigit(int n) {
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}
