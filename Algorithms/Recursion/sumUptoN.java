public class YourClassNameHere {
    public static void main(String[] args) {
      sumToN(10);
    }

  public static   int sumToN(int n)
 {
	if(n == 0)
		return 0;
	int prev = n;
	return prev + sumToN(n-1);
 }
}
