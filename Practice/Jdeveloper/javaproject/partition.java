package javaproject;

import java.util.ArrayList;
import java.util.List;

public class partition {
    public partition() {
        super();
    }
    static java.util.List<java.util.List<String>> output = new java.util.ArrayList<java.util.List<String>>();
    public static void main(String[] args){
        String s = "geeks";
        
        java.util.List<String> single = new java.util.ArrayList<String>();
        for(int i=0;i<s.length();i++)
                single.add(""+s.charAt(i));
        
        output.add(single);
        partition(s,0);
        System.out.println(output);
    }
    
    private static void partition(String s,int start){
        if(start+1 == s.length())
            return;
        
        java.util.List<String> other = new java.util.ArrayList<String>();
        output.add(other);
        String sub = "";
        for(int i=start;i<s.length();i++){
            sub = sub + s.charAt(i);
            if(isPalindrome(sub)){
                if(output.get(1) != null){
                 other.add(sub);   
                }
            
            partition(sub, start+1);    
        }
        }    
    }
    private static boolean isPalindrome(String s){
        StringBuilder stb = new StringBuilder(s);
        return stb.reverse().toString().equals(s);
    }
}
