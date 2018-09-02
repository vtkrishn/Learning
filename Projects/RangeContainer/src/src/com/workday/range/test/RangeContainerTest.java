package com.workday.range.test;

import com.workday.range.RangeContainer;

import com.workday.range.impl.RangeContainerImpl;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RangeContainerTest {
    private RangeContainer rc;
    private static final Logger logger = Logger.getLogger(RangeContainerTest.class.getName());
    
    @Before
    public void setUp(){
        rc = new RangeContainerImpl();
    }
    
    @Test
    public void testRangeContainerImplClass(){
        long start=System.currentTimeMillis();
        //instance not null
        RangeContainer rcinstance = new RangeContainerImpl();
        Assert.assertNotNull(rcinstance);
        long end=System.currentTimeMillis();
        logger.info("It took "+(end-start)+" ms to run the runARangeQuery method");
    }
    
    @Test
    public void testFindIdsInRange(){
        long start=System.currentTimeMillis();
        //object returned should not be null
        Object obj = rc.findIdsInRange(0, 0, false, false);
        Assert.assertNotNull(obj);
        long end=System.currentTimeMillis();
        logger.info("It took "+(end-start)+" ms to run the runARangeQuery method");
    }
    
    @After
    public void tearDown(){
        rc = null;
    }
}
