#Image Hosting Service
* Services - Image Hosting - Image Retrieval Service
* Image Request Handler who handles the requests
* Load Balancer - to balance and routing the requests
* local cache - if the image is there in the cache then fulfil
* global cache - if the image not there in global cache then retrieve and store
* Distributed cache - each request will have its local cache
* Replicate - when image uploaded
* partition - huge data volume for easy access
* proxy Server before the actual server to handle huge requests
* Queue to handle  - Asynchronous requests

#Design Patterns
* Load Balancer
* Scatter and Gather
* cache
* Shared Space
* Pipe and Filter(Queue)
* Map Reduce
* Bulk synchronous
* Execution Orchestrator

#Trending Topic
based on Hashtags
Ranking
Window
Oldest - Latest slots
Map
Circular Linked List
Max Heap

#Facebook Chat Function
Client
Web Tier
Chat Logger
Online/Offline presence - Service
Channel

#Web Crawler
Page Processor
Page Indexer
Page Storage

#Garbage Collection
Mark and sweep
Reference counting
post order traversal
topological sort

#Distributed Content Delivery Network

#Google docs
User
page
buffer
request Queue

#RandomId generator
clock synchronization
timestamp
date
multiple server - id consolidation
radio frequency - generator

#Cache System
frequenctly used in Hash table
compress the data
frequent in memory - less frequent in disk

#Tiny URL
hash Function based on the ascii value
data base sharding

#Recommendation System
user interest
geography
recent watch
user past activity
knowledge model

#Google Search
indexing all the pages
web Crawler

#youtube
Indexing
Storage
sharding
cache

#Hit counter
timestamp - ordering for 1 minute
concurency issue

#News Feed
based on users friends
based on interest
based on subscriptions
Ranking
