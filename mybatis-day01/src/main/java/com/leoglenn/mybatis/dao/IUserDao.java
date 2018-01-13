package com.leoglenn.mybatis.dao;

import com.leoglenn.mybatis.entity.User;

public interface IUserDao {

    /**
     * 根据用户Id获取用户数据
     *
     * @param id
     * @return
     */
    public User findUserById(Integer id);
}
