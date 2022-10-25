package com.mf.skywalking.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

    @GetMapping("/order")
    public String getOrder () {
        return "order";
    }
}
