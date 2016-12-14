import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        String output = "NO";
        int[] charFreq = new int[26];
        int freq = 0;
        int numberOfMinFreqElem = 0;
        int numberOfMaxFreqElem = 0;
        for(int i=0; i< input.length();i++) {
            char c = input.charAt(i);
            charFreq[(c-'a')] += 1;
        }
        Arrays.sort(charFreq);
        int notMatched = 0;
        freq = charFreq[25];
        for(int i=24; (i>0 && notMatched <2 && charFreq[i] != 0);i--) {
            if(charFreq[i] != 0 && charFreq[i] != freq) {
                notMatched ++;
                if(i == 24) {
                    freq = charFreq[i];
                }
            }
        }

        if(notMatched <=1) {
            output ="YES";
        }

        System.out.println(output);

    }
}
