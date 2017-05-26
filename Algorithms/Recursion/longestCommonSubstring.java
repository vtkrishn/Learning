package javaproject;

import java.util.*;
public class Solution4 {
    public static void main(String[] args) {
        String str1 = "ababab";
        String str2 = "gck";
        int i = findCommon(str1,str2);
        System.out.println(i);
    }

    public static int findCommon(String str1, String str2){
      if(str1.equals("") || str2.equals(""))
        return 0;
      int i = str1.length();
      int j = str2.length();
      if(str1.charAt(i-1) == str2.charAt(j-1)){
         return 1 + findCommon(str1.substring(0,i-1), str2.substring(0,j-1));
      }
      return findCommon(str1.substring(0,i-1), str2.substring(0,j-1));
    }
}
