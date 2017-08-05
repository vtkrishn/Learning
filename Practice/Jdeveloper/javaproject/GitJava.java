package javaproject;

import java.util.HashSet;
import java.util.Set;

public class GitJava {
    public GitJava() {
        super();
    }

    public static void main(String[] args){
        int n = 2;
        generateCombination(n);
    }
    
    private static String generateCombination(int n){
        //check if the number is greater than 0
        if(n==0)
            return null;
        
        if(n==1)
            return "0123456789";
        
        if(n > 1){
            StringBuffer stb = new StringBuffer();
            Set<String> set = new HashSet<String>();
            //initilaize the string buffer
                stb.append("00");
                set.add(stb.toString());
            char[] a = {'0','1','2','3','4','5','6','7','8','9'};
            int j = 0;
            String temp = null;
            String stbString = stb.toString();
            int length = stbString.length();
            //take the last element from the buffer - 0 1 0 
            //add the value a[1] - 010
            //add it to the set - 00 01 10
            int max = 0;    
            while(j<a.length){
                temp = stbString.substring(stbString.length()-1);
                    if(!set.contains(temp + a[j])){
                        set.add(temp + a[j]);
                        stb.append(a[j]);
                        stbString = stb.toString();
                        j = 0;
                    }
                    else{
                        j++;
                    }
            }
        }
        return null;
    }
}
