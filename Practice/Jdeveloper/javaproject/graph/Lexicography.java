package javaproject.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lexicography {
    public Lexicography() {
        super();
    }
    
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    
    public static int lengthOfLongestSubstring(String s) {
            int i=0;
            int j=1;
            int currMax=1;
            int max = 0;
            Set set = new HashSet();
            while(j<s.length()){
                if(s.charAt(j) != s.charAt(i) && !set.contains(s.charAt(j))){
                  set.add(s.charAt(i));
                  set.add(s.charAt(j));
                  currMax++;
                }
                else{
                    max = Math.max(max,currMax);
                    i=j;
                    currMax=1;
                    set.clear();
                }
                j++;
            }
            max = Math.max(max,currMax);
            return max;
        }
}

