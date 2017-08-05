package javaproject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution12 {
    public Solution12() {
        super();
    }
    public static void main(String[] args){
        Set<String> dictionary = new HashSet<String>();
        dictionary.add("take");
        dictionary.add("bath");
        dictionary.add("and");
        dictionary.add("come");
        dictionary.add("hand");
        dictionary.add("bat");
        String str = "takebathandcome";
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(findWordBreak(str,"",i,dictionary)){
                count++;
            }
        }
        System.out.println(count);
    }
    
    public static boolean findWordBreak(String str,String sub,int i, Set<String> dictionary){
        if(i+2 == str.length())
            return false;
        if(dictionary.contains(sub)){
            sub = str.substring(i,str.length());
            findWordBreak(str,sub,i+1,dictionary);
        }
        else{
            sub = str.substring(0,i+1);
            findWordBreak(str,sub,i+1,dictionary);    
        }
        
        return true;
    }
}
