package com.mf.zula.springboot.starter.service.impl;

import com.mf.zula.springboot.starter.model.HelloProperties;
import com.mf.zula.springboot.starter.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private HelloProperties helloProperties;

    public String sayHello() {
        return "hello "+ helloProperties.getName() + " welcome to my homepage:" + helloProperties.getUrl();
    }
}
