package com.workday.range.test;

import com.workday.range.RangeContainer;
import com.workday.range.RangeContainerFactory;
import com.workday.range.impl.RangeContainerFactoryImpl;

import com.workday.range.util.Ids;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RangeVolumeTest {
    private RangeContainer rc;
    private short max = Short.MAX_VALUE;
    private static final Logger volumeLogger = Logger.getLogger(RangeVolumeTest.class.getName());
    
    @Before
    public void setUp(){
        RangeContainerFactory rf = new RangeContainerFactoryImpl();
        long[] data = new long[max];
        for(short i = 0; i<max;i++){
            data[i] = i;
        }
        rc = rf.createContainer(data);
    }
    
    @Test
    public void runVolumeQuery(){
        long start=System.currentTimeMillis();
        Ids ids = rc.findIdsInRange(0,max, true, true);
        for(int i=0;i<max;i++){
            Assert.assertEquals(i, ids.nextId());
        }
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        long end=System.currentTimeMillis();
        volumeLogger.info("It took "+(end-start)+" ms to run the runVolumeQuery method");
    }
    
    @After
    public void tearDown(){
        rc = null;
    }
}
