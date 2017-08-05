package javaproject;

import java.util.*;
public class SolutionWordLadder {
  
  static class WordNode{
    String word;
    int numSteps;
 
    public WordNode(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
    }
}

  public static void main(String[] args){
      Set<String> dict = new HashSet();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        buildLadder("hit","cog",dict);
    }
    
  public static int buildLadder(String start, String end,Set<String> dict){
      int len = start.length();
      LinkedList<String> queue = new LinkedList<String>();
      queue.add(start);
      dict.add(end);
      while(!queue.isEmpty()){
          start = queue.removeFirst();
          
          if(start.equals(end))
              return 0;
          for(int i=0;i<len;i++){
              char[] strArray = start.toCharArray();
              for(char j = 'a';j<='z';j++){
                  char t = strArray[i];
                  strArray[i] = j;
                  String conv = new String(strArray);
                  if(dict.contains(conv)){
                      System.out.println(conv);
                      queue.addLast(conv);
                      dict.remove(conv);
                  }
                  
                  strArray[i] = t;
              }              
          }
         
      }
      return 0;
  }
    
    public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));
 
        wordDict.add(endWord);
 
        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
 
            if(word.equals(endWord)){
                return top.numSteps;
            }
 
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
 
                    String newWord = new String(arr);
                    if(wordDict.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        wordDict.remove(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
        }
 
        return 0;
    }
}
