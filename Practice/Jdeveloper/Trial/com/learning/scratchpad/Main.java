package com.learning.scratchpad;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public Main() {
        super();
    }
    
    public static void main(String[] args){
        List<Object> list = new ArrayList<Object>();
        list.add(1);
        List<Object> list2 = new ArrayList<Object>();
        list2.add(2);
        list2.add(3);
        List<Object> list3 = new ArrayList<Object>();
        list3.add(4);
        List<Object> list4 = new ArrayList<Object>();
        list4.add(5);
        list4.add(6);
        list3.add(list4);
        list2.add(list3);
        list.add(list2);
        
        System.out.println("Original list :"+list);
        List<Object> result = new ArrayList<Object>();
        compute(list, 1,result);
        System.out.println("modified for k = 1 : "+result);
        result = new ArrayList<Object>();
        compute(list, 2,result);
        System.out.println("modified for k = 2 : "+result);
        result = new ArrayList<Object>();
        compute(list, 3,result);
        System.out.println("modified for k = 3 : "+result);

    }
    
    private static void compute(List<Object> list, int k,List<Object> result){
        int count = k;
        for(int i=0;i<list.size();i++){
                Object obj = list.get(i);
                if(!(obj instanceof List) || count == 0){
                    result.add(obj);
                }
                else{
                    compute((List)obj, count-1,result);
                }
        }
    }
    
}
