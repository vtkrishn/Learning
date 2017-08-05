package javaproject;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution84 {
    static Set<Integer> s = new HashSet<Integer>();
    public static void main(String[] args) {
      String str="5698157156";
      combo(str,0);
    }
    
    public static boolean combo(String str, int i){
      System.out.println(s.toString());
      if(i == 7 || str.equals("") || s.size() == 7)
        return true;
        
        boolean flag = false;
        int ch1=0;
        int ch2=0;
        int ch3=0;
        ch1 = str.charAt(0)-48;
        if(str.length() > 1){
                ch2 = str.charAt(1)-48;
                ch3 = ch1*10 + ch2;
        }
        
        if(ch3 >= 1 && ch3 <= 59 && !s.contains(ch3))
             s.add(ch3);
        if(str.length() > 1)
             flag = combo(str.substring(2),i+2);
        if(!flag){
           s.remove(ch3);
        }
       
        if(!s.contains(ch1))
            s.add(ch1);
        flag = combo(str.substring(1),i);
        if(!flag){
            s.remove(ch1);
        }
        
      return flag;
    }
}
