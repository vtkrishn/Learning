package javaproject;

import java.util.HashSet;
import java.util.Set;

public class Backtracking {
    public Backtracking() {
        super();
    }
    
    public static void main(String[] args){
        tryCombinations("hit");
    }
    
    public static void tryCombinations(String str){
        char[] ch = str.toCharArray();
        char save;
        for(char c = 'a'; c <= 'z';c++){
            for(int i=0;i<ch.length;i++){
                save = ch[i];
                ch[i] = c;
                System.out.println(ch);
                ch[i] = save;
            }
        }
    }
}
