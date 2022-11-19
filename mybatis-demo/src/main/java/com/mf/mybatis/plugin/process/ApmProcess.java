package com.mf.mybatis.plugin.process;



public interface ApmProcess {
    void handle(Object[] args);

    void print();
}
