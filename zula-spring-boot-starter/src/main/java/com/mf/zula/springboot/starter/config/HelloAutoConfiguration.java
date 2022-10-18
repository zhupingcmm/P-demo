package com.mf.zula.springboot.starter.config;

import com.mf.zula.springboot.starter.model.HelloProperties;
import com.mf.zula.springboot.starter.service.HelloService;
import com.mf.zula.springboot.starter.service.impl.HelloServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnProperty(prefix = "hello.test", name = "enable", matchIfMissing = true)
public class HelloAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService helloService() {
        return new HelloServiceImpl();
    }
}
