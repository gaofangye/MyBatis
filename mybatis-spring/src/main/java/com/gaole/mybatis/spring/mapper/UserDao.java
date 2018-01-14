package com.gaole.mybatis.spring.mapper;

import com.gaole.mybatis.spring.entity.User;

public interface UserDao {
    public User findUserById(Integer id);
}
