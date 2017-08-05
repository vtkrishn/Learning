package javaproject;

import java.util.Iterator;

public class WordLadder {
    public WordLadder() {
        super();
    }
    static java.util.Set<String> wordList = new java.util.HashSet<String>();
    static java.util.List<String> output = new java.util.ArrayList<String>();
    public static void main(String[] args){
        
                wordList.add("hot");
                wordList.add("dot");
                wordList.add("dog");
                wordList.add("lot");
                wordList.add("log");
                findLadders("log","cog");
                System.out.println(output);
    }
    
    private static void findLadders(String source, String target){
        if(!output.contains(source))
        output.add(source);
        //take the source and find closes from the dictionary - hot
        String valueFromList = findClosesFromDictionary(source);
        //find where the change is
        //pass that to findLadder
        if(!output.contains(valueFromList))
        output.add(valueFromList);
        if(valueFromList == findClosesFromDictionary(target)){
            output.add(target);
            return;
        }
        findLadders(valueFromList, target);
    }
    
    private static String findClosesFromDictionary(String source){
        if(source == null)
             return null;
        Iterator it = wordList.iterator();
        while(it.hasNext()){
            String value = (String)it.next();
            if(source.length() == value.length()){
                int j= 0;
                int count = 0;
                while(j<source.length()){
                    if(source.charAt(j) != value.charAt(j))
                        count++;
                    if(count > 1)
                        break;
                    j++;
                }
                if(count == 1)
                 return value;   
                }
            }
        
            return null;
        }
}
