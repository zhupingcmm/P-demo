package com.mf.app;

public class Greeting {
    public String sayHello() {
        String hello = "hello,world, time = " + System.currentTimeMillis();
        System.out.println(hello);
        return hello;
    }
}
