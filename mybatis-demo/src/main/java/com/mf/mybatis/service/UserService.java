package com.mf.mybatis.service;

import com.mf.mybatis.pojo.User;

public interface UserService {
    User findUser(int id);
    void deleteUserById(int id);
    int addUser(User user);
}
