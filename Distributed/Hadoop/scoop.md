Scoop
http://sqoop.apache.org/docs/1.4.6/SqoopUserGuide.html
RDBMS - structure data
if its high structure data.. then its hards to handle in RDBMS
at that time Hadoop can help

scoop is interface between RDBMS and HDFS
importing and exporting the data

built on top MapReduce
by default it will work with 4 Mappers and 0 Reducers

configure number of mappers

-m <no of mappers>

display databases from RDBMS msql for Scoop
scoop list-databases
--connect jdbc:mysql://<hostname>/<database> \
-- username <username> -- password <password> [enter]

import all tables from mysql
scoop import_all_tables
--connect jdbc:mysql://<hostname>/<database> \
-- username <username> -- password <password> \
--fields-terminated-by '\t' [enter]

import tables from mysql
scoop import \
--connect jdbc:mysql://<hostname>/<database> \
-- username <username> -- password <password> \
--table <table_name> --fields-terminated-by '\t' [enter]

import part of the tables from mysql
scoop import \
--connect jdbc:mysql://<hostname>/<database> \
-- username <username> -- password <password> \
--table <table_name> --fields-terminated-by '\t'
--columns "field1,field2.." [enter]

scoop import \
--connect jdbc:mysql://<hostname>/<database> \
-- username <username> -- password <password> \
--table <table_name> --fields-terminated-by '\t'
--where "sal > 1000" -m <no of mapper> \
--columns "field1,field2.."  [enter]

How to export from HDFS to RDMS or Mysql
scoop export \
--connect jdbc:mysql://<hostname>/<database> \
-- username <username> -- password <password> \
--table <table_name> \
--input-fields-terminated-by '\t' \
-- export-dir <directory path> /user/hive/warehouse
