package javaproject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution5 {
    public Solution5() {
        super();
    }
    
    public static void main(String[] args){
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        //wordList.add("dot");
        wordList.add("dog");
        //wordList.add("lot");
        //wordList.add("log");
        //wordList.add("cog");
        
        System.out.println(ladderLength("hot","dog",wordList,0));
    }
    
    public static int ladderLength(String beginWord, String endWord, List<String> wordList,int index) {
         if(beginWord.equals(endWord) || index >= wordList.size())
            return -1;
         
             String temp = wordList.get(index);
             int length = beginWord.length();
             int count =0;
             for(int i = 0;i<length;i++){
                 if(beginWord.charAt(i) != temp.charAt(i))
                     count++;
             }
             if(count == 1){
                 ladderLength(temp, endWord, wordList,index);
             }
             else{
                 return 0;
             }
            return 1 + ladderLength(beginWord, endWord, wordList,index+1);
    }
    
}

