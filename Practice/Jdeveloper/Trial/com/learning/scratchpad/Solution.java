package com.learning.scratchpad;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 Input:
 N test cases:
 N characters separated with space
 Output:
 "SUCCESS => RECEIVED: " + curNum
 or
 "FAILURE => RECEIVED: " + recvNum + ", EXPECTED: " + expNum
 or
 "FAILURE => WRONG INPUT (LINE " + (lineNum) + ")"

 Test case: 1
 3
 3 1 2         SUCCESS => RECEIVED: 3 (we got three events)
 1 5 2 3       FAILURE => RECEIVED: 4, EXPECTED: 5 (the highest number that we got is 5, so we are missing 4 in the sequence from 1)
 4 2 3         FAILURE => RECEIVED: 3, EXPECTED: 4 (the highest number that we got is 4, so we are missing 1 in the sequence from 1)
 Test case: 2f
 2
 1 p 2         FAILURE => WRONG INPUT (LINE 2) (the input contains invalid number)
 3 2           FAILURE => RECEIVED: 2, EXPECTED: 3 (the highest number that we got is 3, so we are missing 1 in the sequence from 1)
 1 3 2 5       FAILURE => WRONG INPUT (LINE 4) (the total test case is 2, so anything more that that is errored out)
 1 2 4 5 3     FAILURE => WRONG INPUT (LINE 5) (the total test case is 2, so anything more that that is errored out)
 */
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
      Scanner scan = new Scanner(System.in);
        //int noOfTestCases = scan.nextInt();
        for(int i = 0;i<1;i++){
             int sum = 0;
            String result = "";
            
            //get each line
            String line = scan.nextLine();
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
