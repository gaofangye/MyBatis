package com.gaole.mybatis.spring.mapper.impl;

import com.gaole.mybatis.spring.mapper.UserDao;
import com.gaole.mybatis.spring.entity.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @author gl
 * @create 2018-01-14-12:46
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
    public User findUserById(Integer id) {
        return this.getSqlSession().selectOne("User.findUserById",id);
    }
}
