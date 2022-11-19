package com.mf.mybatis.service;

import com.mf.mybatis.pojo.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

public class ApplicationContext implements InvocationHandler {

    public <T> T getService(Class <T> clazz){
        Set<Class<?>> interfaces = new HashSet<>();

        return (T) Proxy.newProxyInstance(ApplicationContext.class.getClassLoader(), interfaces.toArray(new Class<?>[0]), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName() == "findUser") {
            return User.builder().name("zp").build();
        }
        return null;
    }
}
