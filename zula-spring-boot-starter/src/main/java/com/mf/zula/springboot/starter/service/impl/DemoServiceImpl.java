package com.mf.zula.springboot.starter.service.impl;

import com.mf.zula.springboot.starter.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String demo() {
        return "demo";
    }
}
