import java.util.*;
public class YourClassNameHere {
    public static void main(String[] args) {
        //largestPrimeFactor(13195);
        largestPrimeFactor(Long.MAX_VALUE);
    }

    public static void largestPrimeFactor(long n){
  	if(n % 2 == 1){
  		long sqrt = (int)Math.sqrt(n);
      	for(long i=sqrt;i>0;i--){
    				if(i % 2 == 1 && n % i == 0 && isPrime(i))
    					System.out.println(i);
    		}
  	  }
  }

    public static boolean isPrime(long n){
        // Corner cases
    if (n <= 1)  return false;
    if (n <= 3)  return true;

    // This is checked so that we can skip
    // middle five numbers in below loop
    if (n%2 == 0 || n%3 == 0) return false;

    for (int i=5; i*i<=n; i=i+6)
        if (n%i == 0 || n%(i+2) == 0)
           return false;

    return true;
    }
}
