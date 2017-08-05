package javaproject.string;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringMain {
    public StringMain() {
        super();
    }
    
    public static void main(String[] args){
        String a = "a";
        String b = "b";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        
//        String divide = "a_simple_divide_string_quest";
//        int len = divide.length();
//        
//        
//        String str1= "geeksforgeeks";
//        String str2= "geeks";
//        Set s1 = new HashSet();
//        String result = "";
//        for(int i=0;i<str2.length();i++){
//            char ch = str2.charAt(i);
//            if(!s1.contains(ch))
//                s1.add(ch);
//        }
//        for(int i=0;i<str1.length();i++){
//            char ch = str1.charAt(i);
//            if(!s1.contains(ch))
//                result = result + ch;
//        }
//        System.out.println(result);
//        
//        String str = "geeksforgeeks";
//        Set s = new HashSet();
//        
//        for(int i=0;i<str.length();i++){
//            char ch = str.charAt(i);
//            if(!s.contains(ch)){
//                s.add(ch);
//                result = result + ch;
//            }
//        }
//        System.out.println(result);
//        
//        
//        int[] count = new int[256];
//        for(int i=0;i<str.length();i++){
//            char ch = str.charAt(i);
//            count[ch]++;
//        }
//        for(int i=0;i<count.length;i++){
//            if(count[i] != 0){
//                System.out.println((char)i + "="+count[i]);
//            }
//        }
    }
}
