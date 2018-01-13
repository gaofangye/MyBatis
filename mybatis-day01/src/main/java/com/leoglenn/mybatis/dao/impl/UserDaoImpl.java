package com.leoglenn.mybatis.dao.impl;

import com.leoglenn.mybatis.dao.IUserDao;
import com.leoglenn.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author gl
 * @create 2018-01-01-18:35
 */
public class UserDaoImpl implements IUserDao {

    /**
     * 创建SqlSessionFactory对象
     */
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 通过构造方法进行对成员变量进行赋值
     *
     * @param sqlSessionFactory
     */
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 根据用户Id获取用户信息
     *
     * @param id
     * @return
     */
    public User findUserById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("test.findUserById", id);
    }
}
