package com.mf.pbatis;

import lombok.val;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resources;
import java.util.List;

public class PbatisTest {
//    private
    @Test
    public void  init(){
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        val resource = PbatisTest.class.getClassLoader().getResourceAsStream("SqlConfig.xml");
        val sqlSessionFactory = builder.build(resource);
        val sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("test.queryUserList");
        for (User user : users) {
            System.out.println(user);
        }

    }
}
