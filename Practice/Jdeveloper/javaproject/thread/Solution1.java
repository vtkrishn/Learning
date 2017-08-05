package javaproject.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution1 {
    int copyCounter = 0;
    
    public static void main(String[] args){
        List<String> wordList= new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        findLadders("hit","cog",wordList);
    }
    
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    HashSet<String> dictionary = new HashSet<String>(wordList);
    List<List<String>> results = new ArrayList<List<String>>();         
    HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
    HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
    ArrayList<String> solution = new ArrayList<String>();

    dictionary.add(beginWord);          
    bfs(beginWord, endWord, dictionary, nodeNeighbors, distance);                 
    dfs(beginWord, endWord, nodeNeighbors, distance, solution, results);   
   return results;
}

// BFS: Trace every node's distance from the start node (level by level).
//in BFS , we can be sure that the distance of each node is the shortest one , because once we have visited a node, we update the distance , if we first met one node ,it must be the shortest distance. if we met the node again ,its distance must not be less than the distance we first met and set.
private static void bfs(String start, String end, Set<String> dictionary, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
  for (String str : dictionary){ //For each word in dictionary set up hashmap to store all of its adjacent neighbours
      nodeNeighbors.put(str, new ArrayList<String>());
  }
  Queue<String> queue = new LinkedList<String>();
  queue.offer(start);//add very start of beginWord to start BFS.
  distance.put(start, 0);//Distance from start to itself is 0.
  
  while (!queue.isEmpty()) {
      int count = queue.size();
      for (int i = 0; i < count; i++) {//You just want to loop each level's neighbours which is just the size of the queue at the current level.
          String cur = queue.poll();
          int curDistance = distance.get(cur);   //Get distance of current node from start             
          ArrayList<String> currentNodesNeighbors = getNeighbors(cur, dictionary);//Get the current node's neighbours
          for (String neighbor : currentNodesNeighbors) { //Loop through current node's neighbours
              nodeNeighbors.get(cur).add(neighbor);//Add all the neighbours into map. 
              if (!distance.containsKey(neighbor)) {// if we have not previously visited this node
                  distance.put(neighbor, curDistance + 1); //increment distance we have travelled.
                  if (end.equals(neighbor)){//if we have reached the end.
                     // return;
                      break;
                      //we don't want to return as there may well be more paths from start to end. So we need to break instead.
                  }
                  else{
                      queue.offer(neighbor);///add neighbour for next level
                  }
              }
          }
      }
      
      }
  }

// Find all next level nodes.    
private static ArrayList<String> getNeighbors(String node, Set<String> dictionary) {
  ArrayList<String> neighbours = new ArrayList<String>();
  char chs[] = node.toCharArray();//Turn to mutable so we can edit it.
  for (char ch ='a'; ch <= 'z'; ch++) { //Try all variations from english alphabet
      for (int i = 0; i < chs.length; i++) {
          if(chs[i] != ch){ //if char is not the same
          char save = chs[i];
          chs[i] = ch;
          //System.out.println(chs);
          if (dictionary.contains(String.valueOf(chs))) {//Check if variation is in dictionary
              neighbours.add(String.valueOf(chs));// If it is add to neighbour List.
          }
          chs[i] = save;//Revert char back to its original char.
          }
      }

  }
  return neighbours; //Return all neighbours of the node.
}

// DFS: output all paths with the shortest distance.
//This is backtracking
private static void dfs(String beginWord, String endWord, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> individualSequence, List<List<String>> results) {
    
    individualSequence.add(beginWord);
    if (endWord.equals(beginWord)) {//Base case for beginWord that has reached endWord and individualSequence has the complete path from the BeginWord to EndWord. So add to the final results list.
       results.add(new ArrayList<String>(individualSequence));
    } else {//We have not reached the end so we must perform DFS on the neighbours.
       for (String next : nodeNeighbors.get(beginWord)) {  //For each neighbour in the beginWord perform DFS to find the next path
           
           
            if (distance.get(next) == distance.get(beginWord) + 1) {// This is just in case that the next node is the next level of current node? otherwise it can be one of the parent nodes of current node?or it is not the shortest node 
            // Since in BFS, we record both the next level nodes and the parent node as neighbors of current node. use distance.get(beginWord)+1 we can make sure the path is the shortest one.
                 dfs(next, endWord, nodeNeighbors, distance, individualSequence, results);
            }
        }
    }        

    //Copy sequence and look at all the elements inside of it to see what the fuck is going on   
   individualSequence.remove(individualSequence.size() - 1); //I think this statement is for backtracking solutions that are invalid.
   
   //You keep on going down the 'tree' until you get to 'cog'. Add the sequence to the results.
   //Then you need to backtrack the neighbours and travel down the tree on a different path. In this example go to '3' then travel down that path to 'cog' again.
   //Keep removing until you backtrack to the very start of beginWord which in this case is "hit".
}
}