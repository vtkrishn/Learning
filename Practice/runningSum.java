package javaproject;

import java.util.HashMap;
import java.util.Map;

public class HashCheck {

        public static void main(String[] args){
            int runningSum = 0;
            int count = 0;
            int start = 1;
            for(int i=1;i<=8;i++){
                runningSum+=i;
                if(runningSum == 15){
                    count++;
                    runningSum=runningSum-start;
                    start++;
                }
                while(runningSum > 15){
                    runningSum=runningSum-start;
                    start++;
                }
                if(runningSum == 15)
                    count++;
            }

            System.out.println(count);
        }


//    public static void main(String[] args){
//        System.out.println(consecutiveSums(15));
//    }
//    public static int consecutiveSums(int sumTo) {
//    int count = 0;
//    for(int i=1;i<sumTo;i++){
//        System.out.println(1);
//         if(helper(i,sumTo, 0)){
//             count++;
//         }
//    }
//    return count;
//}
//
//public static boolean helper(int i, int totalSum , int runningSum){
//  System.out.println(1);
//  if(runningSum == totalSum)
//      return true;
//
//  if(runningSum > totalSum || i > (totalSum/2)+1)
//      return false;
//        return helper(i+1,totalSum,runningSum + i);
//    }
}
