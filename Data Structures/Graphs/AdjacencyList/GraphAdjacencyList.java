package com.graph;

import java.io.FileNotFoundException;


public class GraphAdjacencyList {
    
    public static void main(String args[]){
        Graph g;

        try {
            g = new Graph("C:\\JDeveloper\\mywork\\SampleApplication\\ViewController\\src\\com\\graph\\friends.txt");
            g.print();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
}
