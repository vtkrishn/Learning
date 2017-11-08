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
