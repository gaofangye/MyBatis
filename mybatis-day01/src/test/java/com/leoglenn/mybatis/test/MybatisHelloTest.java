package com.leoglenn.mybatis.test;

import com.leoglenn.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * mybatis -helloworld
 *
 * @author gl
 * @create 2017-12-31-14:57
 */
public class MybatisHelloTest {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws IOException {
//        创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

//        加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

//        创建SqlSessionFactory对象
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void test1() {
//        创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        执行SqlSession对象执行查询,获取结果User
        User user = sqlSession.selectOne("findUserById", 10);

//        打印结果
        System.out.println(user);
    }

    /**
     * 根据username进行模糊查询
     */
    @Test
    public void test2() {
//        创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("findUserByUsername", "五");
        System.out.println(users);
    }

    /**
     * 添加用户
     */
    @Test
    public void test3() {
//        创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("LeoGlenn");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("莲花池");

//        调用SqlSession对象执行插入语句
        sqlSession.insert("test.insertUser", user);
//        插入数据后,必须提交,默认不自动提交事务
        sqlSession.commit();
    }


    /**
     * 添加用户后,返回用户的Id
     */
    @Test
    public void test4() {
//        创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("曾志伟");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setAddress("上海");

        sqlSession.insert("test.insertUser", user);

        sqlSession.commit();

//        添加用户后,立即获取用户的Id
        System.out.println(user.getId());
    }

    /**
     * 修改用户
     */
    @Test
    public void testUpdateUserById() {
//        获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(27);
        user.setUsername("曾志伟");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("湖南");

        sqlSession.update("test.updateUserById", user);
        sqlSession.commit();
    }

    /**
     * 根据用户Id删除用户
     */
    @Test
    public void testDeleteUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(27);

        sqlSession.delete("test.deleteUserById", user);
        sqlSession.commit();
    }

    /**
     * 根据用户Id删除用户方式二
     */
    @Test
    public void testDeleteUserById2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("test.deleteUserById2", 28);
        sqlSession.commit();
    }
}
