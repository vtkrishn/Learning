public class YourClassNameHere {
	    public static void main(String[] args) {
	    Graph g = new Graph();
	    //add all vertexes
	    g.addVertex("Vinod");
	    g.addVertex("Srini");
	    g.addVertex("Zafar");
	    g.addVertex("Victor");
	    g.addVertex("Divya");
	    g.addVertex("Durga");
	    g.addVertex("Sharanya");

	    //add all edges
	    g.addEdge("Vinod","Srini");
	    g.addEdge("Vinod","Zafar");
	    g.addEdge("Zafar","Durga");
	    g.addEdge("Divya","Durga");

	    g.isPathExist("Vinod","Divya");

	    }

	static class Graph{
		java.util.List<java.util.List<Vertex>> vertexes;
		java.util.List<Edge> edgeList;

	class Vertex{
		String data;
		boolean visited;

		public Vertex(String name){
		  this.data = name;
		}

		public String toString(){
			return data;
		}

	}

	class Edge{
		Vertex source;
		Vertex destination;
		int weight;

		public Edge(Vertex s, Vertex d){
		  this.source = s;
		  this.destination = d;
		}
	}

  public boolean isPathExist(String source, String desination){
    boolean flag = false;
    //find the source Vertex
		//find the destination Vertex
		Vertex source = null;
		Vertex destination = null;
		for(int i=0;i<vertexes.size();i++){
		  Vertex temp = vertexes.get(i).get(0);

			if(source == null && temp.toString().equals(s))
				source = temp;

			if(destination == null && temp.toString().equals(d))
				destination = temp;

		}

		if(source != null && destination != null){
		  flag = DFS(source,destination);
		}

		return flag;
  }


	public void addVertex(String vertexName){
		//create new Vertex and add it to the list
		java.util.List<Vertex> newVertexList = new java.util.ArrayList<Vertex>();
		Vertex newVertex = new Vertex(vertexName);
		newVertexList.add(newVertex);

		//if vertex is null initially
		if(vertexes == null){
			vertexes = new java.util.ArrayList<java.util.List<Vertex>>();
		}
		//add the newVertexList to the list
		vertexes.add(newVertexList);
	}

	public void addEdge(String s,String d){
		//find the source Vertex
		//find the destination Vertex
		Vertex source = null;
		Vertex destination = null;
		for(int i=0;i<vertexes.size();i++){
		  Vertex temp = vertexes.get(i).get(0);

			if(source == null && temp.toString().equals(s))
				source = temp;

			if(destination == null && temp.toString().equals(d))
				destination = temp;

		}

		//if source and destination does not exist
		// if(source == null)
		//   addVertex(s);

		// if(destination == null)
		//   addVertex(d);

		//add distination to source vertex list
		//add source to destination vertex list
		Edge edge1 = new Edge(source,destination);
		Edge edge2 = new Edge(destination,source);

		if(edgeList == null)
			edgeList = new java.util.ArrayList<Edge>();
		//add both edges to the edge list
		edgeList.add(edge1);
		edgeList.add(edge2);
		}

	}
 
}
