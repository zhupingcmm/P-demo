package com.mf.demo;

import lombok.val;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceDemo {
    public static void main(String[] args) {
        val context = new ClassPathXmlApplicationContext("spring.xml");
        val userService = context.getBean(UserService.class);
        userService.update3();
    }
}
