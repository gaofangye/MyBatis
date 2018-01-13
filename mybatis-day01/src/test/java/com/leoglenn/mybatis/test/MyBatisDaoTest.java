package com.leoglenn.mybatis.test;

import com.leoglenn.mybatis.dao.IUserDao;
import com.leoglenn.mybatis.dao.impl.UserDaoImpl;
import com.leoglenn.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author gl
 * @create 2018-01-01-18:39
 */
public class MyBatisDaoTest {
    private SqlSessionFactory sqlSessionFactory;
    private IUserDao userDao;

    /**
     * 创建sqlSessionFactory对象
     *
     * @throws IOException
     */
    @Before
    public void before() throws IOException {
//        创建 SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        通过输入流加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        通过配置文件获取 SqlSessionFactory
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }


    @Test
    public void test() {
//        创建 IUserDao对象
        userDao = new UserDaoImpl(sqlSessionFactory);
        User userById = userDao.findUserById(10);
        System.out.println(userById);
    }
}
