package com.mf.demo;

import com.mf.demo.config.AppConfig;
import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserSeviceDemo2 {
    public static void main(String[] args) {
        val context = new AnnotationConfigApplicationContext(AppConfig.class);
        val service2 = context.getBean(UserService2.class);
        service2.update4();
    }
}
