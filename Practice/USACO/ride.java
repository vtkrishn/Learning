http://train.usaco.org/usacoprob2?a=17Pl7E2NwO6&S=ride

/*
ID: vin.sin1
LANG: JAVA
PROG: ride
*/
import java.io.*;
import java.util.*;

public class ride {
  public static void main (String [] args) throws IOException {

	// Use BufferedReader rather than RandomAccessFile; it's much faster
  BufferedReader f = new BufferedReader(new FileReader("ride.in"));
    // input file name goes above
  PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

	// Use StringTokenizer vs. readLine/split -- lots faster
  StringTokenizer st = new StringTokenizer(f.readLine());
  //call the evaluate function which takes two string and return a boolean
  out.println(evaluate(st.nextToken(),st.nextToken()) ? "GO" : "STAY");  // output result
  out.close();  // close the output file

  }

  private static boolean evaluate(String st1,String st2){

    //init product values
  	int product1=1;
  	int product2=1;

    //for each characters in the string multiply with the corresponding position
    //input will be all UPPER CASE - so start from (65-1) to assign position a=1, b=2 otherwise it will be like a=0,b=1
  	for(char ch: st1.toCharArray())
  	  product1 = product1 * Math.abs(64-ch);

  	for(char ch: st2.toCharArray())
  	  product2 = product2 * Math.abs(64-ch);

      //as per the problem mod needs to be taken for 47
  	return (product1 % 47) == (product2 % 47);
}

}
