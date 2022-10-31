package com.mf.zula;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

public class Log4JTest {

    @Test
    public void testQuick() {

        // 初始化配置信息，在入门案例中暂时不使用文件配置
//        BasicConfigurator.configure();
        // 获取日志记录器对象
        LogLog.setInternalDebugging(true);
        Logger logger =  Logger.getLogger(Log4JTest.class);


//        for (int i = 0; i < 10000; i++) {
            logger.fatal("fatal");
            logger.error("error");
            logger.warn("warn");
            logger.info("info");
            logger.debug("debug");
            logger.trace("trace");
//        }

    }
}
