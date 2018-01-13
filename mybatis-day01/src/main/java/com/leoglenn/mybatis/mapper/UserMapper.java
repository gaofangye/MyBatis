package com.leoglenn.mybatis.mapper;

import com.leoglenn.mybatis.entity.User;


/**
 *
 * @author Administrator
 */
public interface UserMapper {

    /**
     * 根据用户Id获取用户
     * @param id
     * @return
     */
    public User findUserById(Integer id);
}
