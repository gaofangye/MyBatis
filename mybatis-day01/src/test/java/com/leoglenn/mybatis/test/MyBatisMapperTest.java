package com.leoglenn.mybatis.test;

import com.leoglenn.mybatis.entity.User;
import com.leoglenn.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author gl
 * @create 2018-01-01-19:01
 */
public class MyBatisMapperTest {

    @Test
    public void test() throws IOException {
//        定义配置文件资源地址
        String resource = "sqlMapConfig.xml";

//        创建 SqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

//        通过输入流将配置文件加载到内存中
        InputStream inputStream = Resources.getResourceAsStream(resource);

//        通过 SqlSessionFactoryBuilder 加载配置文件构建 SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

//        通过 SqlSessionFactory 获取 SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        通过 SqlSession 对象 获取 UserMapper 对象
//        注:这里返回的是一个 UserMapper 的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        通过 UserMapper 执行对应的方法操作数据库
        User userById = mapper.findUserById(10);
        System.out.println(userById);
    }
}
