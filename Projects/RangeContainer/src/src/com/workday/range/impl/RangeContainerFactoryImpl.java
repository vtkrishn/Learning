package com.workday.range.impl;

import com.workday.range.RangeContainer;
import com.workday.range.RangeContainerFactory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implementation for RangeContainerFactory
 */
public class RangeContainerFactoryImpl implements RangeContainerFactory{
    /**
     * Constructor
     */
    public RangeContainerFactoryImpl() {
        super();
    }
    
    /**
     * this method will implement the logic for creating the range container
     * @param data
     * @return the range container
     */
    public RangeContainer createContainer(long[] data) {
        RangeContainerImpl rangeContainer = null;
        //LinkedHashMap is used to maintain the order of the inserted data
        Map<Short, Long> idRangePair = new LinkedHashMap<Short, Long>();
        //store the data in the map as id,value
        if(data != null){
            for(short index =0;index<data.length;index++){
            idRangePair.put(index, data[index]);
            }
            //instantiate the rangeContainer
            rangeContainer = new RangeContainerImpl();
            //set the idRangePair in the container
            rangeContainer.setContainer(idRangePair);
        }
        
        return rangeContainer;
    }
   
}
