package com.mf.mybatis;

import com.mf.mybatis.pojo.User;
import lombok.val;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class MybatisTest {

    private SqlSession sqlSession;
    @Before
    public void testBefore () throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        val resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        val sessionFactory= builder.build(resource);
        sqlSession = sessionFactory.openSession();
    }

    @Test
    public void testFindUsers () {
        List<User> users = sqlSession.selectList("test.findAll");

        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testFindUser(){

        List<User> users = sqlSession.selectList("test.findUser",User.builder()
                .address("魏")
                .build() );
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void updateUser(){
        int res = sqlSession.update("test.updateUser", User.builder().id(1L).age(20).name("皇子").address("蜀国").build());
        System.out.println(res);
    }

    @After
    public void afterTest(){
        sqlSession.close();
    }
}
