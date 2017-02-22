package view.coding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class GraphSolution {
    public GraphSolution() {
        super();
    }
    
    public static void main(String args[]){
        //create empty graph
        Graph g = new Graph();
        System.out.println("Graph :: "+g);
        System.out.println("--------------------------------------------------------------------");
        //add a vertex
        g.addVertex("Mike");
        g.addVertex("Sam");
        g.addVertex("Murphy");
        g.addVertex("John");
        //print graph
        System.out.println("Graph :: "+g);
        System.out.println("--------------------------------------------------------------------");
        //get vertex count
        System.out.println("Vertex count :: "+g.getVertextCount());
        System.out.println("--------------------------------------------------------------------");
        //get vertex
        System.out.println("Retrieved :: "+g.getVertex("Mike"));
        System.out.println("--------------------------------------------------------------------");
        //Create edge between Vertex1 to Vertex2
        g.addEdge("Mike", "Sam");
        g.addEdge("Mike", "Sam");
        g.addEdge("Mike", "John");
        g.addEdge("sam", "Murphy");
        g.addEdge("John", "Murphy");
        g.addVertex("George");
        g.addEdge("Mike", "George");
        System.out.println("Graph :: "+g);
        System.out.println("Edge count :: "+g.getEdgeCount());
        System.out.println("--------------------------------------------------------------------");
        //get neighbour count
        System.out.println("Neighbour count of Mike :: "+g.getNeighbourCount("Mike"));
        System.out.println("--------------------------------------------------------------------");
        //remove Edge between vertex1 and vertex2
        g.removeEdge("Mike", "George");
        System.out.println("Graph :: "+g);
        System.out.println("Edge count :: "+g.getEdgeCount());
        System.out.println("Neighbour count of Mike :: "+g.getNeighbourCount("Mike"));
        System.out.println("--------------------------------------------------------------------");
        //get All Vertex
        System.out.println("All Vertex :: "+g.getAllVertex());
        System.out.println("--------------------------------------------------------------------");
        //get All Neighbours of Vertex
        System.out.println("All Neighbour of Vertex Mike :: "+g.getAllNeighBours("Mike"));
        System.out.println("--------------------------------------------------------------------");
        //has edge between vertex 1 and vertex2
        System.out.println("Has edge between Mike and George :: "+g.hasEdge("Mike", "George"));
        System.out.println("Has edge between Mike and Sam :: "+g.hasEdge("Mike", "Sam"));
        System.out.println("--------------------------------------------------------------------");
        //remove a vertex
        System.out.println("Remove Vertex :: "+g.removeVertex("Mike"));
        System.out.println("Graph :: "+g);
        System.out.println("Vertex count :: "+g.getVertextCount());
    }
    
}
    
class Graph{
    LinkedHashMap<String, ArrayList<Vertex>> adjacencyList;
    int vertexCount;
    int edgeCount;
    
    public Graph(){
        adjacencyList = new LinkedHashMap<String, ArrayList<Vertex>>();
        vertexCount = 0;
        edgeCount=0;
    }
    
    public boolean hasEdge(String v1, String v2){
        if(adjacencyList.containsKey(v1) && adjacencyList.containsKey(v2)){
            ArrayList<Vertex> arr = adjacencyList.get(v1);
            Vertex v = new Vertex(v2);
            if(arr.contains(v))
                return true;
        }
        return false;
    }
    
    public String getAllVertex(){
        StringBuilder s = new StringBuilder();
        for(Map.Entry e : adjacencyList.entrySet()){
            s.append(e.getKey() + "\n");
        }
        return s.length() == 0 ? "[]" : "[\n"+s.toString()+"]";
    }
    
    public String getAllEdges(){
        StringBuilder s = new StringBuilder();
        for(Map.Entry e : adjacencyList.entrySet()){
            s.append(e.getKey() + "\n");
        }
        return s.length() == 0 ? "[]" : "[\n"+s.toString()+"]";
    }
    
    public String getAllNeighBours(String v){
        StringBuilder s = new StringBuilder();
        if(adjacencyList.containsKey(v)){
            ArrayList<Vertex> arr = adjacencyList.get(v);
            Iterator itr = arr.iterator();
            while(itr.hasNext()){
                s.append(itr.next() + "\n");
            }
        }
        return s.length() == 0 ? "[]" : "[\n"+s.toString()+"]";
    }
    
    public void addVertex(String vertexName){
        if(!adjacencyList.containsKey(vertexName)){
            adjacencyList.put(vertexName, null);
            vertexCount++;
        }
    }
    
    public void addEdge(String vertex1, String vertex2){
        boolean flag= false;
        if(adjacencyList.containsKey(vertex1) && adjacencyList.containsKey(vertex2)){
            flag = addToAdjacencyList(vertex2, vertex1);
            flag = addToAdjacencyList(vertex1, vertex2);
            if(flag)
                edgeCount++;
        }
    }
     public void removeEdge(String vertex1, String vertex2){
         boolean flag= false;
         if(adjacencyList.containsKey(vertex1) && adjacencyList.containsKey(vertex2)){
             flag = removeFromAdjacencyList(vertex2, vertex1);
             flag = removeFromAdjacencyList(vertex1, vertex2);
             if(flag)
                 edgeCount--;
         }
     }

    private boolean addToAdjacencyList(String vertex1, String vertex2) {
        ArrayList<Vertex> arr = adjacencyList.get(vertex2);
        Vertex v = new Vertex(vertex1);
        boolean flag = false;
        if(arr != null){
            if(!arr.contains(v)){
                arr.add(v);
                flag = true;
            }
        }
        else{
            arr = new ArrayList<Vertex>();
            arr.add(v);
            flag = true;
        }
        if(flag){
            adjacencyList.put(vertex2, arr);
        }
        return flag;
    }
    
    private boolean removeFromAdjacencyList(String vertex1, String vertex2) {
        ArrayList<Vertex> arr = adjacencyList.get(vertex2);
        Vertex v = new Vertex(vertex1);
        boolean flag = false;
        if(arr != null){
            if(arr.contains(v)){
                arr.remove(v);
                flag = true;
                if(arr.size()==0)
                    arr = null;
            }
        }
        
        if(flag){
            adjacencyList.put(vertex2, arr);
        }
        return flag;
    }
    
    public boolean removeVertex(String vertexName){
        if(adjacencyList.containsKey(vertexName)){
            for(Map.Entry e : adjacencyList.entrySet()){
                if(!e.getKey().equals(vertexName)){
                    ArrayList<Vertex> arr = (ArrayList<Vertex>)e.getValue();
                    if(arr != null){
                        Iterator itr = arr.iterator();
                        while(itr.hasNext()){
                            Vertex v = (Vertex)itr.next();
                            if(v.getVertexName().equals(vertexName))
                                arr.remove(v);
                        }
                    }
                }
            }
            adjacencyList.remove(vertexName);
            vertexCount--;
            
            return true;
        }
        return false;    
    }
    
    public Vertex getVertex(String vertexName){
        if(adjacencyList.containsKey(vertexName)){
            return new Vertex(vertexName);
        }
        else{
            return null;
        }
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Map.Entry e : adjacencyList.entrySet()){
            s.append(e.getKey() + "->" + e.getValue() + "\n");
        }
        return s.length() == 0 ? "[]" : "[\n"+s.toString()+"]";
    }
    
    public int getVertextCount(){
        return vertexCount;
    }
    
    public int getEdgeCount(){
        return edgeCount;
    }
    
    public int getNeighbourCount(String v){
        if(adjacencyList.containsKey(v)){
            ArrayList<Vertex> arr = adjacencyList.get(v);
            return arr.size();
        }
        return 0;
    }
}
class Edge{
    int edgeWeight;
    Vertex start;
    Vertex end;


    public void setEdgeWeight(int edgeWeight) {
        this.edgeWeight = edgeWeight;
    }

    public int getEdgeWeight() {
        return edgeWeight;
    }

    public void setStart(Vertex start) {
        this.start = start;
    }

    public Vertex getStart() {
        return start;
    }

    public void setEnd(Vertex end) {
        this.end = end;
    }

    public Vertex getEnd() {
        return end;
    }
}
class Vertex{
    String vertexName;

    public Vertex(String vertexName){
        this.vertexName = vertexName;
    }
    public void setVertexName(String vertexName) {
        this.vertexName = vertexName;
    }

    public String getVertexName() {
        return vertexName;
    }
    
    public String toString(){
    return vertexName;    
    }
    
    public int hashCode(){
        return vertexName.hashCode();
    }
    
    public boolean equals(Object obj){
        if(obj instanceof Vertex)
            return ((Vertex)obj).hashCode() == vertexName.hashCode();
        return false;
    }
    
}
