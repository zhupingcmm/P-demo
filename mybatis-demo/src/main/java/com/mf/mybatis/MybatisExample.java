package com.mf.mybatis;

import com.mf.mybatis.pojo.User;
import lombok.val;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.util.List;

public class MybatisExample {
    public static void main(String[] args) throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        val resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        val sessionFactory= builder.build(resource);
        val sqlSession = sessionFactory.openSession();
        List<User> users = sqlSession.selectList("test.findAll");

        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
