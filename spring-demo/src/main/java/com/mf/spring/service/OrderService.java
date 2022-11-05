package com.mf.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class OrderService {

    private UserService userService;

    public void test(){
        System.out.println(userService);
    }
}
