package com.mf.hello.demo.controller;

import com.mf.zula.springboot.starter.service.DemoService;
import com.mf.zula.springboot.starter.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private DemoService demoService;

    @GetMapping("/test")
    public String test(){
        String demo = demoService.demo();
        System.out.println(demo);
        return helloService.sayHello();
    }
}
