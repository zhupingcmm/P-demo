package com.mf.mybatis.plugin.process;

public abstract class AbstractProcess implements ApmProcess{

    private long startTime = System.currentTimeMillis();

    private String logContent;

    public void setLogContent(String content){
        this.logContent = content;
    };

    public  void print() {
        long takeTime = System.currentTimeMillis() - startTime;
        System.out.println("[" + takeTime + " ms" + "] " + logContent);
    };
}
