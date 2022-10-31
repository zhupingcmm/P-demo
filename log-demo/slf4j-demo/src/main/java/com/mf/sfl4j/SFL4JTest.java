package com.mf.sfl4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SFL4JTest {
    public static final Logger logger = LoggerFactory.getLogger(SFL4JTest.class);

    @Test
    public void  testQuick() {

        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");

        // 占位符
        String name = "zp";
        logger.info("user, {}", name);

        // 异常信息输出
        try {
            int i = 1/0;
        } catch (Exception e) {
            logger.error("出现异常", e);
        }

    }
}
