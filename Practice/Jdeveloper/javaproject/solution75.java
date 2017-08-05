package javaproject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class solution75 {
    static String[] str = {"bread","pizza", "ham"};
    public solution75() {
        super();
    }
    
    public static void main(String[] args){
        for(int i=0;i<3;i++)
            printValue(i,0);
    }
    
    public static void printValue(int i, int count){
        if(count == 3)
           return;
        System.out.println(str[i]);
        for(int j=1;j<3;j++){
            printValue(i,count+1);
            printValue(i,count+2);
        }
    }
}
