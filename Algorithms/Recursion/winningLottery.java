package javaproject;

import java.util.*;
public class Solution86 {
  public static void main(String[] args) {


        String[] str1 = {"ab12345yu"," ","569815571556", "4938532894754", "1234567", "472844278465445","12","76543210","12304567","1634616512","5698157156"};
        String[] str2 = {"4938532894754","1234567","5698157156"};
        String[] str3 = {"5698157156"};
//          for(String s: str1){
//              if(isValidString(s))
//                  continue;
//              else{
//                  Set<Integer> hs = new LinkedHashSet<>();
//                  if(combo(s, hs, 0)) {
//                          System.out.println(hs + " : "+ s);
//                  }
//              }
//          }
//
//          System.out.println("------------");
//          for(String s: str2){
//              if(isValidString(s))
//                  continue;
//              else{
//                  Set<Integer> hs = new LinkedHashSet<>();
//                  if(combo(s, hs, 0)) {
//                          System.out.println(hs + " : "+ s);
//                  }
//              }
//          }
//          System.out.println("------------");
          for(String s: str3){
              if(isValidString(s))
                  continue;
              else{
                  Set<Integer> hs = new LinkedHashSet<>();
                  if(combo(s, hs, 0)) {
                          System.out.println(hs + " : "+ s);
                  }
              }
          }
          System.out.println("------------");
  }

  public static boolean combo(String s, Set<Integer> hs, int i){
  	if(i == s.length() && hs.size() == 7) return true;
  	if(i> s.length() || hs.size() > 7 || s.length() < 7-hs.size()) return false;

  	boolean flag = false;
  	int value = (int) s.charAt(i) - 48;
                if(isValid(value, hs)){
                        hs.add(value);
                        flag = combo(s, hs,i+1);
                        if(!flag) {
                            hs.remove(value);
                        }
                }
  	if(!flag && i+1 < s.length()){
  		value = Integer.parseInt(s.substring(i,i+2));
  		if(isValid(value, hs)) {
  			hs.add(value);
  			flag = combo(s,hs,i+2);
  			if(!flag) {
                            hs.remove(value);
  			}
  		}
  	}
  	return flag;
  }

    private static boolean isValidString(String str){
        return str.length() > 14 || str.length() < 7 || !str.matches("[0-9]+");
    }

  public static boolean isValid(int value, Set<Integer> hs){
  	if(value < 1 || value > 59 || hs.contains(value)) return false;
  	return true;
  }
}
