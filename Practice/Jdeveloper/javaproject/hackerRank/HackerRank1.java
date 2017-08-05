package javaproject.hackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import java.util.TreeMap;

import javaproject.tree.Tree;

public class HackerRank1 {
    public HackerRank1() {
        super();
    }
    
    public static void main(String[] args) throws IOException{
//        String[] s = {"1.1837 1.3829 0.6102", "1.1234 1.2134 1.2311"};
//            System.out.println(arbitrage(s)[0]);
//            System.out.println(arbitrage(s)[1]);
          
//            String[] s1 = {"Alex","Michael","Harry","Dave","Michael","Victor","Harry","Alex","Mary","Mary"};
//            String[] s2 = {"Victor","Veronica","Ryan","Dave","Maria","Maria","Farah","Farah","Ryan","Veronica"};
//            electionWinner(s1);
        
        String tree = "3 4 5 1 3 # 1";
        findMax(6,tree);
        }
       
        static long findMax(int n, String tree) {
            String[] node = tree.split(" ");       
            int max = Integer.MIN_VALUE;
            for(int i=0;i<node.length;i++){
                if(!node[i].equals("#"))
                max = Math.max(findMax(node,i, true),findMax(node,i, false));
            }
            return max;
        }
            static int findMax(String[] node, int index, boolean selected){
                if(index + 2 >= node.length || index + 1 >= node.length)
                    return 0;
                Integer left = Integer.parseInt(node[index+1]);
                Integer right = Integer.parseInt(node[index+2]);
                if(selected)
                    //Add all element for 2 power i
                else
                    //Add all element for 2 power i
                
                return Math.max(left,right);
            }
        
        static String electionWinner(String[] votes) {
            TreeMap<String,Integer> result = new TreeMap<String,Integer>(Collections.reverseOrder());
            for(int i =0;i<votes.length;i++){
                 result.put(votes[i],result.getOrDefault(votes[i], 1) + 1);      
            }
            int max = Integer.MIN_VALUE;
            String output = null;
            for(Map.Entry<String,Integer> entry : result.entrySet()){
                String key = entry.getKey();
                int value = entry.getValue();
                if(max < value){
                    max = value;
                    output = key;
                }
            }
            return output;
        }
    
        static int[] arbitrage(String[] quotes) {
            int[] result = new int[quotes.length];
            for(int i=0;i<quotes.length;i++){
                String[] items = quotes[i].split(" ");
                double totalAmout = 100000;
                double usdValue = Double.parseDouble(items[0]);
                double eurValue = Double.parseDouble(items[1]);
                double gbpValue = Double.parseDouble(items[2]);
                
                double EURbought = totalAmout / usdValue;
                double GBPbought = EURbought / eurValue;
                double USDbought = GBPbought / gbpValue;
                int arbitrage = (int)(USDbought - totalAmout);
                result[i] = USDbought < totalAmout ? 0 : arbitrage;
            }
            return result;
        }
}
