Common Scalability

load Balance
  Cloning
  Replication
database
  NoSQL
Caching
  In memory [Objects, Queries]
Asynchronous

Vertical Scaling - Make single machine more powerful
Bigger machines
More CPU
  Task Parallelism
  Distribute separate task on separate computer
More RAM

Load Balancing
    Even task - round robin task assignment
    Weighted task - assign based on the weights the server can handle
    Sticky Session - same session likeness to go to same server
    Even size Task Queue - task queue for each of the server
    Autonomous - each server takes what it can process

Caching
      Browser - Cache
      Web Server - cache
      Database - cache

  populate cache
        upfront Caching
        Lazy Caching
  Remote computer Sync
  Managing Cache  
    Time based eviction
    FIFO
    FILO
    Least accessed
    Least time between access

Denormalize the data
  store the data as it is - fast approach
  one disk write
  no Joins

Sharding - data for user A stored in one server, data for user B stored in different server, group of 500k user stored in shards
  High Availablity
  Faster queries - small data means fast access
  more write bandwidth
