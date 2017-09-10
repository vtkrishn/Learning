package com.learning.scratchpad;

import java.util.*;
public class WordLadder {
    static List<List<String>> result = new ArrayList<List<String>>();
    static List<String> tempList = new ArrayList<String>();
    static Map<String,List<String>> map = new HashMap<String,List<String>>();
    
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
        Set<String> visited= new HashSet<String>();
        Set<String> unVisited= new HashSet<String>(wordList);
        
        LinkedList<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        
        unVisited.add(endWord);
        unVisited.remove(beginWord);
        
        while(!queue.isEmpty()){
            String word = queue.poll();
            if(!tempList.contains(word))
                tempList.add(word);
            
            if(word.equals(endWord)){
                result.add(tempList);
            }
            else{
                for(int j = 0;j<beginWord.length();j++){
                    char[] tempChar = beginWord.toCharArray();
                    //permute
                    for(char i='a';i<='z';i++){
                        tempChar[j] = i;
                        String tempWord = new String(tempChar);
                        //check if it exists in the wordList
                        if(wordList.contains(tempWord) && !visited.contains(tempWord)){
                            visited.add(tempWord);
                            queue.offer(tempWord);
                        }
                        
                        if(map.containsKey(tempWord))
                            map.get(tempWord).add(word);
                        else{
                            
                        }
                    }      
                }
            }
        }
        return result;
    }
}
