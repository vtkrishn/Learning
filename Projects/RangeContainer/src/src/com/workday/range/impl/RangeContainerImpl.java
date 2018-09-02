package com.workday.range.impl;

import com.workday.range.RangeContainer;
import com.workday.range.util.Ids;

import java.util.LinkedList;
import java.util.Map;

public class RangeContainerImpl implements RangeContainer {
    private Map<Short, Long> container;
    /**
     * Constructor
     */
    public RangeContainerImpl() {
        super();
    }
    
    /**
     * This method will find the id's in thegiven range  
     * @param fromValue
     * @param toValue
     * @param fromInclusive
     * @param toInclusive
     * @return the Ids
     */
    public Ids findIdsInRange(long fromValue, long toValue,
                              boolean fromInclusive, boolean toInclusive) {
            //boolean to evaluate the inclusiveness
            boolean conditionFlag = false;
            Sequence idSequence = new Sequence();
            //fromValue should be greater than 0 and toValue should be greater than fromValue
            if(fromValue >= 0 && fromValue < toValue){
            //loop through the Map entry sets
            for (Map.Entry<Short, Long> entry : container.entrySet())
            {
                    long entryValue = entry.getValue();
                    if(fromInclusive){// >=
                        if(toInclusive){ //<=
                            conditionFlag = entryValue >=fromValue && entryValue <= toValue;
                        }
                        else{//<
                            conditionFlag = entryValue >=fromValue && entryValue < toValue;
                        }
                    }
                    else{
                        if(toInclusive){//<=
                            conditionFlag = entryValue > fromValue && entryValue <= toValue;
                        }
                        else{//<
                            conditionFlag = entryValue > fromValue && entryValue < toValue;
                        }
                    }
                    
                    if(conditionFlag){
                        idSequence.setId(entry.getKey());
                    }                   
            }
        }
            
        return idSequence;
    }

    /**
     * set the id range pair in the container
     * @param container
     */
    public void setContainer(Map<Short, Long> container) {
        this.container = container;
    }
    
    /**
     * Inner class implementation of Ids
     */
    private class Sequence implements Ids{
        LinkedList<Short> queue;
        /**
         * Constructor
         */
        Sequence(){
            queue = new LinkedList<Short>();
        }
        
        /**
         * pop out the first element in the queue
         * @return
         */
        public short nextId() {
            while(queue.listIterator().hasNext()){
                return queue.pop();    
            }
            
            return END_OF_IDS;
        }
        
        /**
         * Add id to the queue
         * @param id
         */
        public void setId(short id) {
            this.queue.add(id);
        }
    }
}
