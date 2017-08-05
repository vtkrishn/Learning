package javaproject.graph;

import java.util.Scanner;

public class Class1 {
    public Class1() {
        super();
    }
    
    public static void main(String[] args){
        int n = 150;
              int k = (n > 10) ? n/10 : n;
              int[] dp = new int[k+1];
              dp[0] = 1;
              int count = 1;
              int i=2;
              int temp = 1;
              while(count <= n){
                 if(i%2==0 || i%3 == 0 || i%5 == 0){
                      dp[temp] = i;
                      count++;
                      temp++;
                 }
                 i++;
                 if(temp > k){
                  temp = 0;
                  dp[temp] = i;
                 }
              }
                System.out.println(dp[temp]);
    }
}
