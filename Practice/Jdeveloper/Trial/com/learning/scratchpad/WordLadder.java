package com.learning.scratchpad;

import java.util.*;
public class WordLadder {
    static Set<String> processedSet = new HashSet<String>();
    
    public static void main(String[] args){
      List<String> wordList = new ArrayList<String>();
      wordList.add("hit");
      wordList.add("hot");
      wordList.add("dot");
      wordList.add("lot");
      wordList.add("dog");
      wordList.add("log");
      wordList.add("cog");
      findLadders("hit","cog",wordList);
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> tempList = new ArrayList<String>();
        LinkedList<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            String word = queue.poll();
            if(!tempList.contains(word))
                tempList.add(word);
            if(word.equals(endWord)){
                result.add(tempList);
            }
            else{
             String output = checkWord(word, wordList);
                if(output != null){
                    queue.offer(output);
                }   
            }
        }
        return result;
    }
    
    private static String checkWord(String beginWord, List<String> wordList){
        for(int j = 0;j<beginWord.length();j++){
            char[] tempChar = beginWord.toCharArray();
            //permute
            for(char i='a';i<='z';i++){
                tempChar[j] = i;
                String tempWord = new String(tempChar);
                //check if it exists in the wordList
                if(wordList.contains(tempWord) && !processedSet.contains(tempWord)){
                    processedSet.add(tempWord);
                    return tempWord;
                }
            }      
        }
        return null;
    }
}
