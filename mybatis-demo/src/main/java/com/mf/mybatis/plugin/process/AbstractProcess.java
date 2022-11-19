package com.mf.mybatis.plugin.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractProcess implements ApmProcess{
    protected static final Logger logger = LoggerFactory.getLogger(AbstractProcess.class);
    private long startTime = System.currentTimeMillis();

    private String logContent;

    public void setLogContent(String content){
        this.logContent = content;
    };

    public  void print() {
        long takeTime = System.currentTimeMillis() - startTime;
        logger.info("[{} ms] {}", takeTime, logContent);
    };
}
