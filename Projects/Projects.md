client - api - rest - hhtp - header - content type - ssl - web.xml - servlet - path - compression - encoding- http - servlet-mapping
- filtering - ranges - pagination - caching -


#How do you deal with conflict?
##Follow these guidelines for handling conflict in the workplace.

    Talk with the other person.
    Focus on behavior and events, not on personalities.
    Listen carefully.
    Identify points of agreement and disagreement.
    Prioritize the areas of conflict.
    Develop a plan to work on each conflict.
    Follow through on your plan.

    love solving the problem from big customer having the large data as it present you different challenges                        
    say for change that b2b experience you have now you want to do  something on consumer space suggesting there is lot to learn there as you have to be agile to move with changes also there will no room for error talk that you think it is right size where you have blend of intelligent people and you will have chance to learn from them and grow
    for conflict say if you are open for the opinion will never have conflict say peers most of the time conflit happens when your theory or design is not liked or vice versa it is really important to understand why my peer thinks that this will not solve and be open at the same time giving the prospective to him/her on why I think that can resolve. The more we communicate and learn the more we can resolve the issue with peer. For manager mention most of the time the conflict or differences happens on the estimates the time so it is really important to communicate as early as possible for any roadblocks.. also letting him/her know why I think it is complex or simple.
#Advanced Search Filter
Word Search
##Three character Search
 - Front end - JSF - component
   * binds to the managed bean
   * data controller
   * access the model details and executes the query
   * Frequent query results are cached
   * less DB round trips
   * Upper function for the table columns
   * indexing the table
   * Optimization - for free text search
   * improving query performance
   * hints - query hints
   * SQL tuning excercise - look for no FTS , joins
   * SQL profiling , rewriting the SQL
   * remove unnecessary FTS
   * if the table is small and its FTS then cache it
   * /* FIRST ROWS *
   * temporary table  - complex queries
   * use minus instead of exists (NOT in or NOT)
   * using analytical functions
   * index the null values
   * avoid not in, and havings.. use not exists
   * us nvl, decode etc

#performance
 * Inside the While loop instatiation - object creation - not finalized
 * having loops to iterate for the value each time. used the SET to add the values and if it exists then add the clause

#Audit Trial tool
 * Customer faces production problem - the war file is deployed to log all the information
 * dump is given to us for further analysis
 * this will resolve long call with the customer to get to the detail of the issues
 * the tool will log and page parameters, state of the flow, what user did, mouse events, what is the error he got

#REST micro service
loading place - truck drivers
Geo location for the truck drivers to get to the load point efficiently
reducing the wait time by implementing efficient algorithm to find the minimum wait time
previous loading status is exposed
String getStatusofCurrentLoad() - LOADING, UNLOADING, PREPARING, LOAD COMPLETED, UNLOAD COMPLETED
int getQueueSize() - how many are there in the queue
boolean reserveASlot() - reserve if its available, otherwise add to the queue
getReservationDetails() - get the reservation details
getEstimatedLoadTime() -

#pickup scheduling
Have to research some online papers
consider - total miles , delay in the pickup, efficiently reduce the wait time
Time window to schedule
bypass - limit, sort the location information - shorter is closer, load time evaluation to adjust for the next stop
- the load time is compared with the other loads in the next possible scheduling area and then see how
- once scheduled - remove the location and the truck from the list
free slots - [s1, s2, s3,s4]
trucks in transit - [t1,t2,t3]
distance [t1 : 125, t2 : 100, t3 : 70]

T3 - will be scheduled first, T3 : S1 (Random)
remove s3,t3 from the list

- T3 is no slots available - look into the other slots which is scheudled in the reverse order which will be likely to get over [s3,s2,s1]
