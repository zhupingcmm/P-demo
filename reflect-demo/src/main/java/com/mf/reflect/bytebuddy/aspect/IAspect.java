package com.mf.reflect.bytebuddy.aspect;

import java.lang.reflect.Method;

public interface IAspect {

    void beforeMethod(Object objectInst, Method method, Object[] allArguments, Object result) throws Throwable;;

    Object afterMethod(Object objectInst, Method method, Object[] allArguments, Object result) throws Throwable;;

    void handleMethodException(Object objInst, Method method, Object[] allArguments, Throwable t);

}
