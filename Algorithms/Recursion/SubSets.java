package javaproject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Solution76 {
    public Solution76() {
        super();
    }

    public static void main(String[] args){
     Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        printSubset(set);
        System.out.println(set.toString());
    }

    public static void printSubset(Set<String> set){
        List<String> list = new ArrayList<String>(set);
        for(int i=0;i<list.size();i++){
            subset(i,set,list,""+list.get(i));
        }
    }

    public static void subset(int i, Set<String> set,List<String> list,String result){
        set.add(result);
        for(int j=i+1;j<list.size();j++){
            subset(j,set,list,result+list.get(j));
        }
    }
}
