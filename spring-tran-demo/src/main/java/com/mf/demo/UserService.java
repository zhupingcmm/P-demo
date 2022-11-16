package com.mf.demo;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

//@Component
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    TransactionTemplate transactionTemplate;



    public void update3 () {
        jdbcTemplate.update("update t_user set name = ? where id = ?", "oooo", 1);
        val abc = 1/0;
    }
    public void update2 (){
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    jdbcTemplate.update("update t_user set name = ? where id = ?", "cpp", 1);
                    val a = 1/0;
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }

    public void update(){
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        val transactionStatus = transactionManager.getTransaction(definition);

        try {
            jdbcTemplate.update("update t_user set name = ? where id = ?", "zp", 1);
            val a = 1/0;
        } catch (Exception e){
            System.out.println("exception");
            transactionManager.rollback(transactionStatus);
        } finally {
            System.out.println("finally");
            transactionManager.commit(transactionStatus);
        }


    }
}
