package com.workday.range.test;

import com.workday.range.RangeContainer;
import com.workday.range.RangeContainerFactory;
import com.workday.range.impl.RangeContainerFactoryImpl;

import com.workday.range.impl.RangeContainerImpl;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RangeContainerFactoryTest {
    RangeContainerFactory rf;
    private static final Logger logger = Logger.getLogger(RangeContainerFactoryTest.class.getName());
    
    @Before
    public void setUp(){
        rf = new RangeContainerFactoryImpl();
    }
    
    @Test
    public void testRangeContainerFactoryImplClass(){
        long start=System.currentTimeMillis();
        RangeContainerFactory rcFactoryInstance = new RangeContainerFactoryImpl();
        Assert.assertNotNull(rcFactoryInstance);
        long end=System.currentTimeMillis();
        logger.info("It took "+(end-start)+" ms to run the runARangeQuery method");
    }
    
    @Test
    public void testCreateContainer(){
        long start=System.currentTimeMillis();
        //pass null data
        RangeContainer rc = rf.createContainer(null);
        Assert.assertNull(rc);
        //if empty data
        rc = rf.createContainer(new long[]{});
        Assert.assertNotNull(rc);
        //pass correct data
        rc = rf.createContainer(new long[]{1});
        Assert.assertNotNull(rc);
        //pass negative data
        rc = rf.createContainer(new long[]{-1,-2,-3});
        Assert.assertNotNull(rc);
        //pass long max data
        rc = rf.createContainer(new long[]{1121212121212121212L});
        Assert.assertNotNull(rc);
        //pass long min data
        rc = rf.createContainer(new long[]{-1121212121212121212L});
        Assert.assertNotNull(rc);
        long end=System.currentTimeMillis();
        logger.info("It took "+(end-start)+" ms to run the runARangeQuery method");
    }
    
    @After
    public void tearDown(){
        rf = null;
    }
}
