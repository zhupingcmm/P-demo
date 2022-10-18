package com.mf.zula.springboot.starter.config;

import com.mf.zula.springboot.starter.service.DemoService;
import com.mf.zula.springboot.starter.service.impl.DemoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoAutoConfiguration {
    @Bean
    public DemoService demoService() {
        return new DemoServiceImpl();
    }
}
