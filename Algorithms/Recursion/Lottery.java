package javaproject;

import java.util.LinkedHashSet;
import java.util.Set;

public class Solution89 {
        static Set<Integer> set = new LinkedHashSet<Integer>();
        public static void main(String[] args) {
          String[] str = {"ab12345yu"," ","569815571556", "4938532894754", "1234567", "472844278465445","12","76543210","12304567","1634616512"};
          for(int i=0;i<str.length;i++){
              if(isValid(str[i]))
                  continue;
              else{
                    findLotteryWith2Digits(str[i],0,str[i]);
                  if(set.size() == 7)
                    System.out.println(str[i]);
                  else{
                    set.clear();
                    findLotteryWith1Digits(str[i],0);
                      if(set.size() == 7)
                        System.out.println(str[i]);
                  }
              }
              set.clear();
          }
        }

        /*
         * is the string valid number sequence
         */
        private static boolean isValid(String str){
            return str.length() > 14 || str.length() < 7 || !str.matches("[0-9]+");
        }

        /*
         * get the logttery sequence with only 1 digits
         */
        private static void findLotteryWith1Digits(String str,int count){
          if(count == 7 || str.equals(""))
            return;
          else{
            int ch = str.charAt(0)-48;
                //if set does not contain the single digit then add to it
                addToSet(ch);
                findLotteryWith1Digits(str.substring(1),count+1);
              }
          }

        /*
         * get the logttery sequence involving 2 digits
         */
        private static void findLotteryWith2Digits(String str,int count,String orig){
            //if count is 7 or there is no string to process or if the set size reaches 7 then return
            if(count == 7 || str.equals("") || set.size() == 7){
                return;
            }
          else{
            //get the first digit of the string
            int ch = str.charAt(0)-48;
            //process the second digit if there is more that 1 digit
            int append = (str.length() > 1) ? (ch*10) + str.charAt(1)-48 : ch;
              //is the digits in range
              if(append > 10 && append < 59){
                  //if set does not contain the 2 digits then add to it
                  addToSet(append);
                  //call for the next 2 digits
                  findLotteryWith2Digits(str.substring(2),count+1,orig);
              }
              else{
                  //if set does not contain the single digit then add to it
                    addToSet(ch);
                    findLotteryWith2Digits(str.substring(1),count+1,orig);
              }
          }
        }

        /*
         * Add to the set after checking for existance
         */
        private static void addToSet(int append) {
                if(!set.contains(append))
                  set.add(append);
        }
}
