package com.mf.mybatis.plugin;

import com.mf.mybatis.plugin.process.ApmProcess;
import com.mf.mybatis.plugin.process.impl.QueryProcess;
import com.mf.mybatis.plugin.process.impl.UpdateProcess;

import java.lang.reflect.Method;

public class ApmFactory {
    private final static String QUERY_METHOD = "query";
    private final static String UPDATE_METHOD = "update";
    private ApmProcess apmProcess;


    public ApmFactory(Method method, Object [] args){
        switch (method.getName()){
            case UPDATE_METHOD:
                apmProcess = new UpdateProcess(args);
                break;
            default:
                apmProcess = new QueryProcess(args);
        }

    }

    public void process(){
        apmProcess.handle();
    }

    public void print(){
        apmProcess.print();
    }


}
