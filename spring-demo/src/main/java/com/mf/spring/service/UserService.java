package com.mf.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;



@Component
public abstract class UserService {


//    @Autowired
//    private OrderService orderService123;

    @Lookup("orderService")
    public OrderService test(){
        return null;
    }
}
