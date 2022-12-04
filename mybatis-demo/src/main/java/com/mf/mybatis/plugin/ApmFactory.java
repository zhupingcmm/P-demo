package com.mf.mybatis.plugin;

import com.mf.mybatis.plugin.process.ApmProcess;
import com.mf.mybatis.plugin.process.impl.QueryProcess;
import com.mf.mybatis.plugin.process.impl.UpdateProcess;

import java.lang.reflect.Method;

public class    ApmFactory {
    private final static String UPDATE_METHOD = "update";


    public static ApmProcess build (Method method) {

        switch (method.getName()){
            case UPDATE_METHOD:
                return new UpdateProcess();
            default:
                return new QueryProcess();
        }
    }

}
