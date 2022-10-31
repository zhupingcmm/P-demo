package com.mf.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

public class Slf4jTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(Slf4jTest.class);
    @Test
    public void test01(){
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }
}
