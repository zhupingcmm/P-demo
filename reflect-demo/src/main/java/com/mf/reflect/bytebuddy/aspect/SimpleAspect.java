package com.mf.reflect.bytebuddy.aspect;

import java.lang.reflect.Method;

public class SimpleAspect implements IAspect{
    @Override
    public void beforeMethod(Object objectInst, Method method, Object[] allArguments, Object result) throws Throwable {
        System.out.println(" before method");
    }

    @Override
    public Object afterMethod(Object objectInst, Method method, Object[] allArguments, Object result) throws Throwable {
        System.out.println(" after method");
        return result;
    }

    @Override
    public void handleMethodException(Object objInst, Method method, Object[] allArguments, Throwable t) {
        System.out.println("an exception thrown from method()");

    }
}
