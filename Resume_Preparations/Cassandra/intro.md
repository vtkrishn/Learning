Wide column
Highly Scalable
No single point of failure
------------------
A Cluster is a collection of Data Centers.
A Data Center is a collection of Racks.
A Rack is a collection of Servers.
A Server contains 256 virtual nodes (or vnodes) by default.
A vnode is the data storage layer within a server.
------------
KeySpaces  is like databases in RDBMS
Cluster is a container of key KeySpaces

    The column, which is a name/value pair
    The row, which is a container for columns referenced by a primary key
    The table, which is a container for rows
    The keyspace, which is a container for tables
    The cluster, which is a container for keyspaces that spans one or more nodes

data types
--------------
int , text, ascii, uuid, inet, counter, blob , set , list, etc
set - {}
list - []
map - {:}
---------
Default cluster - Test Cluster
$ bin/cqlsh
bin/cqlsh localhost 9042
-----------------------------------------
cqlsh> DESCRIBE CLUSTER;
Cluster: Test Cluster
Partitioner: Murmur3Partitioner
-----------------------------------------
cqlsh> DESCRIBE KEYSPACES;
system_auth   system_distributed  system_schema
system        system_traces
------------------------------------------
cqlsh> SHOW VERSION;
[cqlsh 5.0.1 | Cassandra 3.0.0 | CQL spec 3.3.1 | Native protocol v4]
-----------------------------------------
CREATE KEYSPACE my_keyspace WITH replication = {'class':
  'SimpleStrategy', 'replication_factor': 1};

DESCRIBE KEYSPACE my_keyspace

USE my_keyspace;
----------------------------------------
Data center
Racks
nodes
clusters
---------------
Gossips
Failure Detection
Snitches
Ring
Token
Virtual nodes
Partitioner
Replication SimpleStrategy
Queries
Consistency levels
Coordinator nodes
Memtables
sstables
commit logs
caching
hinted handoff
paxos
lightweight transactions
tombstones
bloom filters
