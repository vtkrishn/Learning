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

public class RangeQueryBasicTest {
    private RangeContainer rc;
    private static final Logger basicQueryLogger = Logger.getLogger(RangeQueryBasicTest.class.getName());
    
    @Before
    public void setUp(){
        RangeContainerFactory rf = new RangeContainerFactoryImpl();
        rc = rf.createContainer(new long[]{10,12,17,21,2,15,16});
    }
    
    @Test
    public void runARangeQuery(){
        long start=System.currentTimeMillis();
        //in range
        Ids ids = rc.findIdsInRange(14, 17, true, true);
        Assert.assertEquals(2, ids.nextId());
        Assert.assertEquals(5, ids.nextId());
        Assert.assertEquals(6, ids.nextId());
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //in range
        ids = rc.findIdsInRange(14, 17, true, false);
        Assert.assertEquals(5, ids.nextId());
        Assert.assertEquals(6, ids.nextId());
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //in range
        ids = rc.findIdsInRange(20, 21, false, true);
        Assert.assertEquals(3, ids.nextId());
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //in range
        ids = rc.findIdsInRange(0,25, true, true);
        Assert.assertEquals(0, ids.nextId());
        Assert.assertEquals(1, ids.nextId());
        Assert.assertEquals(2, ids.nextId());
        Assert.assertEquals(3, ids.nextId());
        Assert.assertEquals(4, ids.nextId());
        Assert.assertEquals(5, ids.nextId());
        Assert.assertEquals(6, ids.nextId());
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //in range
        ids = rc.findIdsInRange(0,10, true, false);
        Assert.assertEquals(4, ids.nextId());
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //in range
        ids = rc.findIdsInRange(16,21, false, false);
        Assert.assertEquals(2, ids.nextId());
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //in range
        ids = rc.findIdsInRange(13,19, false, true);
        Assert.assertEquals(2, ids.nextId());
        Assert.assertEquals(5, ids.nextId());
        Assert.assertEquals(6, ids.nextId());
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        long end=System.currentTimeMillis();
        basicQueryLogger.info("It took "+(end-start)+" ms to run the runARangeQuery method");
    }
    
    @Test
    public void runAInvalidfromValueQuery(){
        long start=System.currentTimeMillis();
        //Starting with 0 is not valid
        Ids ids = rc.findIdsInRange(0,0, true, true);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //exclude
        ids = rc.findIdsInRange(0,0, false, true);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //Starting with 0 is not valid
        ids = rc.findIdsInRange(0,1, true, true);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //exclude
        ids = rc.findIdsInRange(0,1, false, true);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //Starting with negative is not valid
        ids = rc.findIdsInRange(-1,0, true, true);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //exclude
        ids = rc.findIdsInRange(-1,0, false, true);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //fromValue Exceeded long MAX is not valid
        ids = rc.findIdsInRange(Long.MAX_VALUE+1,Long.MAX_VALUE+2, true, true);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //exclude
        ids = rc.findIdsInRange(Long.MAX_VALUE+1,Long.MAX_VALUE+2, false, true);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        long end=System.currentTimeMillis();
        basicQueryLogger.info("It took "+(end-start)+" ms to run the runAInvalidfromValueQuery method");
    }
    
    @Test
    public void runAInvalidtoValueQuery(){
        long start=System.currentTimeMillis();
        //Starting with 0 is not valid
        Ids ids = rc.findIdsInRange(0,0, true, true);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //exclude
        ids = rc.findIdsInRange(0,0, true, false);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //Ending with negative is not valid
        ids = rc.findIdsInRange(10,-4, true, true);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //exclude
        ids = rc.findIdsInRange(10,-4, true, false);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //toValue Exceeded long MAX is not valid
        ids = rc.findIdsInRange(0,Long.MAX_VALUE+1, true, true);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //exclude
        ids = rc.findIdsInRange(0,Long.MAX_VALUE+1, true, false);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //toValue less than fromValue is not valid
        ids = rc.findIdsInRange(10, 1, true, true);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        //exclude
        ids = rc.findIdsInRange(10, 1, true, false);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        long end=System.currentTimeMillis();
        basicQueryLogger.info("It took "+(end-start)+" ms to run the runAInvalidtoValueQuery method");
    }
    
    @After
    public void tearDown(){
        rc = null;
    }

}
