1) use column names instead of '*'
2) use having only for group by filter and avoid if the filtering can be done using the where clause
3) try to minimize the sub queries
4) in is slow performance. use in if the filter is there in the subquery. if the filter is there in the main query then use EXISTS
5) use union all instead of union.
6) use decode

best practices
1) avoid Full table scan
2) uses indexes
3) try to rewrite SQL
4) use joins
5) for small tables with FTS then cache it
6) use nvl ,decode operation
7) query hint and optimizers
8) query profiling
9) index null values
