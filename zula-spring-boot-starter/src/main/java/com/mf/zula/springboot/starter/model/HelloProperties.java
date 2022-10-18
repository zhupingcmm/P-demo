package com.mf.zula.springboot.starter.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix ="hello.test")
@Data
public class HelloProperties {
    private boolean enable;
    private String name;
    private String url;
}
