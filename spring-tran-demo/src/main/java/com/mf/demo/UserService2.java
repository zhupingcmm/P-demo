package com.mf.demo;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserService2 {

    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Autowired
//    PlatformTransactionManager transactionManager;

    @Autowired
    UserService3 userService3;

    @Transactional
    public void update4 () {
        jdbcTemplate.update("update t_user set password = ? where id = ?", "999", 1);
        try {
            userService3.update5();
        } catch (Exception e) {
            System.out.println(e);
//            e.printStackTrace();
        }

//        val abc = 1/0;
    }
}
