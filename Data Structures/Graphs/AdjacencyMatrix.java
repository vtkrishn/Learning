public class YourClassNameHere {
	    public static void main(String[] args) {
	      Graph g = new Graph(3);
	      g.addEdges(0,1);
	      g.addEdges(1,2);
	    }
	    
	    static class Graph{
	      int n;
	      boolean[][] matrix;
	      
	      public Graph(int n){
	        this.n = n;
	        matrix = new boolean[n][n];
	      }
	      
	      public void addEdges(int i , int j){
	        matrix[i][j] = true;
	      }
	      
	      public void removeEdges(int i , int j){
	        matrix[i][j] = false;
	      }
	      
	      public boolean hasEdge(int i, int j){
	        return matrix[i][j];
	      }
	      
	      public java.util.List<Integer> inEdge(int i){
	         java.util.List<Integer> edges = new java.util.ArrayList<Integer>();
	         for(int j=0;j<n;j++){
	            if(matrix[j][i])
	              edges.add(j);
	         }
	         return edges;
	      }
	      
	      public java.util.List<Integer> outEdge(int i){
	         java.util.List<Integer> edges = new java.util.ArrayList<Integer>();
	         for(int j=0;j<n;j++){
	            if(matrix[i][j])
	              edges.add(j);
	         }
	         return edges;
	      }
	      
	    }
	}
