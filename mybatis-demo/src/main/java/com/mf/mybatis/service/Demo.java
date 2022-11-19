package com.mf.mybatis.service;

import lombok.val;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();
        val service = applicationContext.getService(UserService.class);

        val user = service.findUser(1);
//        service.deleteUserById(1);
        System.out.println(user);
    }
}
