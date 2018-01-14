package com.gaole.mybatis.spring.test;

import com.gaole.mybatis.spring.entity.User;
import com.gaole.mybatis.spring.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring整合mybatis测试类
 *
 * @author gl
 * @create 2018-01-14-12:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringMybatisTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        User user = userMapper.findUserById(10);

        System.out.println(user);
    }
}
