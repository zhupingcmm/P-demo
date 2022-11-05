package com.mf.spring;

import com.mf.spring.annotation.PrototypeBean;
import com.mf.spring.service.OrderService;
import com.mf.spring.service.UserService;
import org.springframework.context.annotation.*;

@ComponentScan("com.mf.spring")
@PropertySource("classpath:spring.properties")
@Configuration
public class AppConfig {

//    @Bean
//    public UserService userService123() {
//        return new UserService();
//    }
//
//
//    @Bean
//    public OrderService orderService() {
//        return new OrderService();
//    }
}
