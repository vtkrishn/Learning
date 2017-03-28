public class YourClassNameHere {
	    public static void main(String[] args) {
	      Graph g = new Graph();
	      g.addVertex(0);
	      g.addVertex(1);
	      g.addVertex(2);
	      g.addEdges(0,1);
	      g.addEdges(1,2);
	      g.outEdge(0);
	    }
	    
	    static class Graph{
	      java.util.List<Integer>[] list;
	      
	      public Graph(){
	        list = new java.util.ArrayList[3];
	      }
	      
	      public void addVertex(int vertex){
	        list[vertex] = new java.util.ArrayList<Integer>();
	      }
	      
	      public void addEdges(int i , int j){
	        if(list[i] != null)
	           list[i].add(j);
	      }
	      
	      public void removeEdges(int i , int j){
	        if(list[i] != null)
	           list[i].remove(j);
	      }
	      
	      public boolean hasEdge(int i, int j){
	        return list[i].contains(j);
	      }
	      
	      public java.util.List<Integer> inEdge(int i){
	         java.util.List<Integer> edges = new java.util.ArrayList<Integer>();
	         for(int j=0;j<list[i].size();j++){
	            if(list[j].contains(i))
	              edges.add(j);
	         }
	         
	         return edges;
	      }
	      
	      public java.util.List<Integer> outEdge(int i){
	         return list[i];
	      }
	      
	    }
	}
