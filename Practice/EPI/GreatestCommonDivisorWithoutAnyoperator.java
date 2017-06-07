public class YourClassNameHere {
    public static void main(String[] args) {
      gcd(24,300);
    }

    public static int gcd(int x, int y){
      if(x == y)
        return x;
      if((x & 1) == 0 && (y & 1) == 0)//both even
        return gcd(x >>> 1, y >>> 1) << 1;
      if((x & 1) == 0 && (y & 1) != 0)//x even and y odd
        return gcd(x >>> 1, y);
      if((x & 1) != 0 && (y & 1) == 0)//x odd and y even
        return gcd(x, y >>> 1);
      if(x > y) //both odd and x > y
        return gcd(x-y,y);
      else
        return gcd(x,y-x); //both odd, y > x
    }
}
