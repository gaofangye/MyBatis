package com.gaole.mybatis.spring.mapper;

import com.gaole.mybatis.spring.entity.User;

/**
 * User 动态代理接口
 *
 * @author Administrator
 */
public interface UserMapper {

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User findUserById(Integer id);
}
