import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(isValid(s.next()));
    }

    static String isValid(String str){
	      int[] c = new int[26];
          int[] x = new int[26];
	      for(int i=0;i<str.length();i++){
	        char ch = str.charAt(i);
	        int index= Math.abs(97-ch);
	        if(c[index] == 1)
	          c[index] = 0;
	        else
	          c[index] = 1;

            x[index]++;
	      }

	     int sum = 0;
	     for(int i=0;i<26;i++){
               sum = sum + c[i];
	     }
        System.out.println(sum);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
               if(x[i] != 0){
                   max = Math.max(x[i],max);
                   min = Math.min(x[i],min);
               }
	    }
         return sum <= 1 ? "YES" : Math.abs(max-min) <= 1 ? "YES" : "NO";
	    }
}
