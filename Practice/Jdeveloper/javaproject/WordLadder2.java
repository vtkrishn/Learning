package javaproject;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder2 {
    static Set<String> addedWords = new HashSet<String>();
    public static void main(String[] args){
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        findLadders("hit","cog",wordList);
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        Deque<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        while(!queue.isEmpty()){
                String str = queue.poll();
                List<String> list = bfs(str,wordList,map,endWord);
                map.put(str,list);
            for(int i=0;i<list.size();i++){
                String str2 = list.get(i);
                if(!map.containsKey(str2))
                    queue.add(str2);
            }
        }
        
        List<String> ll = new ArrayList<String>();
        ll.add(beginWord);
        for(Map.Entry<String,List<String>> e : map.entrySet()){
            
            List<String> list = map.get(beginWord);
            for(int i=0;i<list.size();i++){
                String str2 = list.get(i);
                ll.add(str2);
            }
        }
        return null;
    }
    
    public static List<String> bfs(String str, List<String> wordList,Map<String,List<String>> map,String endWord){
            List<String> tempList = new ArrayList<String>();
            for(int i=0;i<3;i++){
                    char[] charArray = str.toCharArray();
                    char temp = charArray[i];
                    for(char j='a';j<='z';j++){
                            charArray[i] = j;
                            String tempString = new String(charArray);
                            if(wordList.contains(tempString)){
                                    if(!str.equals(tempString)){
                                        if(!tempString.equals(endWord)){
                                            tempList.add(tempString);
                                            wordList.remove(tempString);
                                        }
                                    }
                            }
                    }
                    charArray[i] = temp;
            }
            return tempList;
    }

}

