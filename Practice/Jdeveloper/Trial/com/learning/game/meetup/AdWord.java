package com.learning.game.meetup;

public class AdWord {
    public AdWord() {
        super();
    }
    
    public static void main(String[] args){
        int max = getMinimumMaximumLength("I have cool pet", 2);
        System.out.println(max);
    }
    
    private static int getMinimumMaximumLength2(String sentence,int k){
        String[] splits = sentence.split(" ");
        if(splits.length <= k)
            return getMaxLength(splits);
        
        int start = 0;
        int end = 0;
        int i = 0;
        int j = splits.length-1;
        int min = Integer.MAX_VALUE;
        int sentenceLength = sentence.length();
        while(i<j){
            start = start + splits[i].length();
            end = end + splits[j].length();
            min = Math.min(sentence.substring(start+1,sentenceLength).length(), sentence.substring(0,sentenceLength-end).length());
            
            i++;
            j--;
        }
        
        return min;
    }
    
    private static int getMinimumMaximumLength(String sentence,int k){
        String[] splits = sentence.split(" ");
        int[] dp = new int[splits.length+1];
        if(splits.length <= k)
            return getMaxLength(splits);
        dp[0] = splits[0].length()+1;
        
        int currMax = 0;
        for(int i=1;i<splits.length;i++){
           int currLen = splits[i].length()+1;
             currMax = Math.max(currMax, Math.max(dp[i-1],currLen));
           dp[i] = dp[i-1] + currLen;
        }
        return 0;
    }
    
    private static int getMaxLength(String[] splits){
        int max = 0;
        for(int i=0;i<splits.length;i++)
            max= Math.max(0,splits[i].length()+1);
        return max;
    }
    
}
