public void bfs(int vertex){
  boolean[] visited = new boolean[n]; // no of vertex
  
  LinkedList<Integer> q = new LinkeList<Integer>();
  visited[vertex] = true;
  q.add(vertex);
  
  while(queue.size() != 0){
    q.poll(); // dequue
    System.out.println(vertex);
    
    Iterator it = adjList[vertex].listIterator(); //get the vertex adjacency list
    while(it.hasNext()){
      int neighbor = it.next();
      if(!visited[neighbor]){
        q.add(neighbor);
        visited[neighbor] = true;
      }
    }
  }
}

public void bfsRecursive(Queue q,boolean[] visited){
  if(q.size() == 0)
    return;
  
  int c = q.poll();
  System.out.println(c);
  Iterator it = adjList[vertex].listIterator(); //get the vertex adjacency list
    while(it.hasNext()){
      int k = it.next();
      q.add(k);
      visited[k] = true;
      bfsRecursive(q,visited);
    }
}
