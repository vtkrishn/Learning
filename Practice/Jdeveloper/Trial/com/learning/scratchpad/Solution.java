package com.learning.scratchpad;

import java.util.Scanner;


public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
      Scanner scan = new Scanner(System.in);
        //int noOfTestCases = scan.nextInt();
        for(int i = 0;i<1;i++){
            int sum = 0;
            String result = "";
            
            //get each line
            String line = scan.next();
            //get the events
            String[] events = line.split(" ");
            int maxEventId = Integer.MIN_VALUE;
            
            //get the max of event in the line
            for(int j=0;j<events.length;j++){
                int eventId = 0;
                try{
                    eventId = Integer.parseInt(events[j]);
                    maxEventId = Math.max(maxEventId, eventId);
                }
                catch(NumberFormatException ex){
                    result = "FAILURE => WRONG INPUT (LINE "+ (i+2) + ")";
                    break;
                }
            }
            
            if(result.equals("")){
                //get the sum upto the max
                for(int j=1;j<=maxEventId;j++)
                    sum = sum + j;
                
                //for each of the event
                for(int j=0;j<events.length;j++){
                    int eventId = 0;
                    try{
                        eventId = Integer.parseInt(events[j]);
                        sum = sum - eventId;
                    }
                    catch(NumberFormatException ex){
                        result = "FAILURE => WRONG INPUT (LINE "+ (i+2) + ")";
                        break;
                    }
                }
                
                if(sum == 0){
                    result = "SUCCESS => RECEIVED: "+ maxEventId;
                }
                else{
                    result = "FAILURE => RECEIVED: "+ events.length + ", EXPECTED: " + maxEventId;
                }
            }
            
            
            //display result
            System.out.println(result);
        }
        
    }
}
