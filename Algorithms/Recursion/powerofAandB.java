public class YourClassNameHere {
    public static void main(String[] args) {
        pow(12,4);
    }

  public static int pow(int a,int b){
	return (b == 1) ? a : (b % 2 == 0 ? pow(a * a ,b >> 1) : a * pow(a * a ,(b-1) >> 1));
  }
}
