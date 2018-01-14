package com.gaole.mybatis.test;

import com.gaole.mybatis.entity.Orders;
import com.gaole.mybatis.entity.User;
import com.gaole.mybatis.mapper.OrdersMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 订单测试类
 *
 * @author gl
 * @create 2018-01-13-17:24
 */
public class OrdersMapperTest {
    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test1() throws IOException {
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        List<Orders> orders = ordersMapper.findAll();
        for (Orders order : orders) {
            System.out.println(order);
        }

    }

    @Test
    public void test2() {
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> orders = ordersMapper.queryOrdersUser();
        for (Orders order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void test3() {
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<User> users = ordersMapper.queryUserOrders();
        for (User user : users) {
            System.out.println(user + "," + user.getOrders());
        }

    }
}
