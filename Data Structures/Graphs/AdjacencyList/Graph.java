package com.graph;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

public class Graph {
    Vertex[] adjList;
    public Graph(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        int vertexLength = sc.nextInt();
        //init vertex length
        adjList = new Vertex[vertexLength];
        
        //read vertex
        for(int i=0;i<vertexLength;i++){
            adjList[i] = new Vertex(sc.next(),null);
        }
        
        //read edges
        while(sc.hasNext()){
            int v1 = indexForName(sc.next());
            int v2 = indexForName(sc.next());
            
            adjList[v1].neighbor = new Neighbor(v2,adjList[v1].neighbor);
            adjList[v2].neighbor = new Neighbor(v1,adjList[v2].neighbor);
        }
                    
        
    }
    
    private int indexForName(String name){
        for(int i=0;i<adjList.length;i++){
            if(adjList[i].name.equals(name)){
                return i;
            }
        }
         return -1;
    }
    
    public void print(){
        for(int i = 0 ;i<adjList.length;i++){
            System.out.print(adjList[i].name);
            Neighbor n = adjList[i].neighbor;
            while(n != null){
                System.out.print("-- " + adjList[n.index].name);
                n = n.next;
            }
            System.out.print("\n");
        }
    }
}
