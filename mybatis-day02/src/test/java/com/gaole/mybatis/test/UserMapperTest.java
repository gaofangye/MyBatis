package com.gaole.mybatis.test;

import com.gaole.mybatis.mapper.UserMapper;
import com.gaole.mybatis.entity.QueryVo;
import com.gaole.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * User对象测试类
 *
 * @author gl
 * @create 2018-01-13-16:44
 */
public class UserMapperTest {

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
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("王");
        queryVo.setUser(user);

        List<User> users = mapper.findByQueryVo(queryVo);

        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        load configuration file,create SqlSessionFactory Object
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

//        find SqlSession Object
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        find table totalSize
        Integer countUser = mapper.countUser();

        System.out.println(countUser);
    }

    @Test
    public void test3() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


        User user = new User();
        user.setSex("1");
        user.setUsername("张");

        List<User> users = userMapper.findBySexAndUsername(user);

        for (User user1 : users) {

            System.out.println(user1);
        }

    }

    @Test
    public void test4() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> listIds = new ArrayList<Integer>();

        listIds.add(24);
        listIds.add(25);
        listIds.add(26);

        QueryVo queryVo = new QueryVo();
        queryVo.setListIds(listIds);

        List<User> byIds = userMapper.findByIds(queryVo);
        for (User byId : byIds) {
            System.out.println(byId);
        }
    }

    @Test
    public void test4_1() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> listIds = new ArrayList<Integer>();

        listIds.add(24);
        listIds.add(25);
        listIds.add(26);

        List<User> byIds = userMapper.findByIds(listIds);
        for (User byId : byIds) {
            System.out.println(byId);
        }
    }

    @Test
    public void test5() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Integer[] arryIds = {24, 25, 26};

        QueryVo queryVo = new QueryVo();
        queryVo.setArrayIds(arryIds);

        List<User> byIds = userMapper.findByIds(queryVo);
        for (User byId : byIds) {
            System.out.println(byId);
        }
    }

    @Test
    public void test5_1() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Integer[] arryIds = {24, 25, 26};

        QueryVo queryVo = new QueryVo();
        queryVo.setArrayIds(arryIds);

        List<User> byIds = userMapper.findByIds(arryIds);
        for (User byId : byIds) {
            System.out.println(byId);
        }
    }

    @Test
    public void test6() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.queryUserOrders();
        for (User user : users) {
            System.out.println(user + "-" + user.getOrders());
        }

    }
}
