#Adjacency Matrix
  * used for easy retrieval if there is a path check
  * for dense and closely connected
  * consumes more space
#Adjacency List
  * to check if the path exists - have to go each column and each vertex
  * saves space

#BFS
 * init all visitied to false - size of vertex
 * then create a queue
 * add the vertex passed to the method
 * while - queue is not empty
 * poll the queue
 * iterate and check if it hasnext then go inside
 * set visited = true
  * insert into the queue

#DFS    
* init all visitied to false - size of vertex
* then create a stack
* add the vertex passed to the method
* while - stack is not empty
* top the stack
* iterate and check if it hasnext then go inside
* set visited = true
 * insert into the stack

#Applications of DFS
* path finding
* detecting cycles
* Topological sort
* strongly connected
* bipartide

#Applications of BFS
* Shortest path
* garbage collection
* path finding
* crawler
* peer to peer networks

# Longest path
* do topological sort
#Find Mother Vertex
* do DFS, keep track of last finished vertex
* then do the DFS from v

#Topological sort
* do same as DFS
* but pushiing the stack will be outside the second loop
