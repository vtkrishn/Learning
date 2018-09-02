package com.workday.range.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { RangeQueryBasicTest.class, RangeVolumeTest.class,RangeContainerFactoryTest.class,RangeContainerTest.class })
public class AllTests {
}
