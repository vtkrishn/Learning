package javaproject;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Solution87 {
    static List<List<String>> list = new ArrayList<List<String>>();
    public Solution87() {
        super();
    }
    
    public static void main(String[] args){
        String str = "1234567";
        List<String> l = new ArrayList<String>();
        Set<String> set = new LinkedHashSet<String>();
        findLottery(str, 0,set);
        System.out.println(set.toString());
    }
    
    private static void findLottery(String str,int count,Set<String> set){
        if(count == 7 || str.equals("")){
            return;
        }
        int ch1 = str.charAt(0)-48;
        int ch2 = str.length() > 1 ? str.charAt(1)-48 : 0;
        int both = (ch1*10) + ch2;
        if(both > 10 && both < 59){
            set.add(String.valueOf(both));
            if(str.length() > 1)
                findLottery(str.substring(2), count+1,set);
        }
        else{
            if(ch1 > 0)
            set.add(String.valueOf(ch1));
            if(ch2 > 0)
            set.add(String.valueOf(ch2));
            if(str.length() > 1)
                findLottery(str.substring(2), count+1,set);
            //else
              //  findLottery(str.substring(1), count+1,set);
        }
        findLottery(str.substring(1), count+1,set);
    }
}
