public void dfs(int vertex){
  
  boolean[] visited = new boolenn[n];
  Stack s = new Stack();
  s.push(vertex);
  visited[vertex] = true;
  
  while(!stack.isEmpty()){
    stack.pop();
    System.out.println(vertex);
   
   Iterator it = adjList[start].listIterator();
   while(it.hasNext()){
   int c= it.next();
    if(!vissted[c]){
      stack.push(c);
      visited[c] = true;
    }
   }
  
  }
}
