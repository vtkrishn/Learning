http://elasticsearch-cheatsheet.jolicode.com/
## Elastic

```
java -version

https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-5.6.3.tar.gz

tar –xvf elasticsearch-2.1.0.tar.gz
wget -qO - https://packages.elastic.co/GPG-KEY-elasticsearch | sudo apt-key add -

echo "deb http://packages.elastic.co/elasticsearch/2.x/debian stable main" | sudo tee -a /etc
   /apt/sources.list.d/elasticsearch-2.x.list

   sudo apt-get update
   sudo apt-get install elasticsearch


```
https://bonsai.io/clusters/first-cluster-3632559849
```
{
  "name" : "T7dK1d2",
  "cluster_name" : "elasticsearch",
  "cluster_uuid" : "8U3avhzSQFq59NCgnqhSBg",
  "version" : {
    "number" : "5.4.3",
    "build_hash" : "eed30a8",
    "build_date" : "2017-06-22T00:34:03.743Z",
    "build_snapshot" : false,
    "lucene_version" : "6.5.1"
  },
  "tagline" : "You Know, for Search"
}
```

INDEX
```
PUT /movies
{"acknowledged":true,"shards_acknowledged":true}
```
```
GET /movies

{"movies":{"aliases":{},"mappings":{},"settings":{"index":{"creation_date":"1510129491994","number_of_shards":"1","number_of_replicas":"1","uuid":"jb9-vc2rSUyUw_DsbXnIoA","version":{"created":"5040399"},"provided_name":"movies"}}}}
```

POST
```
POST /movies/_bulk

{"index":{"_index":"movies","_type":"movie","_id":"100001"}}
{"name":"Padayappa","actor":"rajini"}
{"index":{"_index":"movies","_type":"movie","_id":"100002"}}
{"name":"Chellame","actor":"vishal"}
{"index":{"_index":"movies","_type":"movie","_id":"100003"}}
{"name":"Dum","actor":"simbhu"}

{"took":45,"errors":false,"items":[{"index":{"_index":"movies","_type":"movie","_id":"100001","_version":1,"result":"created","_shards":{"total":2,"successful":2,"failed":0},"created":true,"status":201}},{"index":{"_index":"movies","_type":"movie","_id":"100002","_version":1,"result":"created","_shards":{"total":2,"successful":2,"failed":0},"created":true,"status":201}}]}
```
SEARCH
```
movies/_search?q=name=Chellame

{"took":14,"timed_out":false,"_shards":{"total":1,"successful":1,"failed":0},"hits":{"total":1,"max_score":0.62191015,"hits":[{"_index":"movies","_type":"movie","_id":"100002","_score":0.62191015,"_source":{"name":"Chellame","actor":"vishal"}}]}}
```
territories/_search?q=name:Mayil
