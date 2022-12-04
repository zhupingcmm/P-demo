package com.mf.spring.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class UserService {
    @Value("${pzhu}")
    public String pzhu;
    public OrderService test(){
        System.out.println(pzhu);
        return null;
    }
}
