Domain Naming service (DNS)

Domain Name : google.com
Top Level Domain Name : com, au, org, net
ip address : 10.256.34.56
host : api.google.com , code. google.com (individual servers)
Zone file : simple file having the mapping of domain name and ip address
Record : single entry  or domain to ip address, name server for the domain, mail server for the domain

How DNS works
Root servers : they have information regardng the top level domain (com,org) - there are total 13 available
forwards the request to the nearest mirror of that server
TLD Server : will chk the zone file and forward to the name server
Domain name server : this will find the coreesponding ip address match in its seever and replies back

forward lookup - resolves the name and returns the ip address
reverse lookup - when an ip address is given it returns the domain name

DNS cache - it stores the ip address to the domain name and returns from the cache if it exists already

DNS acting as Load balancing
DNS round robin - have the information of the all the web servers and retrives the web server in round robin
DNS weighted - assign weights to the server to determine the load

Primary DMS server - Write Master
Secondary DNS server - Read Replica
