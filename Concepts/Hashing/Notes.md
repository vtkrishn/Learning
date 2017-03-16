#### Hashing
immutable is used because the hashcode will not change - key is determine based on that

String class hashcode
`s.charAt(0) * 31n-1 + s.charAt(1) * 31n-2 + ... + s.charAt(n-1)``

##### Collision
Collision happens if two hashcode are same
#Collision Resolution
Open Hashing/Separate Chaining
  spearate chaining - linked list ,
  Hashtable becomes an array of lists

load factor - for the list length

perfect Hashing

#open Addressing
* linear probing - Closed Addressing/Open Addressing, until a slot is found
* quadratic probing - take the collision index and add some value until a slot is found
* double Hashing - interval is retrieved using different hash function

#linear probing  
if index k is not avaialable try to place it at k + 1 index

#Hash chaining
* linked list

#hash functions
murmur and FNV - non cryptographic
