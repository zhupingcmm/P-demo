package com.mf.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class JCLTest {

    @Test
    public void testQuick() {
        Log log = LogFactory.getLog(JCLTest.class);

        log.info("hello jcl");
    }

}
