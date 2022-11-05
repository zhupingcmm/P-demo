package com.mf.spring;

import com.mf.spring.service.OrderService;
import com.mf.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        UserService userService = (UserService) context.getBean(UserService.class);
        System.out.println(userService.test());

    }
}
