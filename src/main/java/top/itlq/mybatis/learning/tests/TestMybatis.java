package top.itlq.mybatis.learning.tests;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import top.itlq.mybatis.learning.dao.User;
import top.itlq.mybatis.learning.dao.in.UserMapper;

import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static top.itlq.mybatis.learning.utils.MybatisUtils.sqlSessionFactory;
import static top.itlq.mybatis.learning.utils.MybatisUtils.sqlSessionFactoryWithJava;

public class TestMybatis {
    /**
     * xml形式
     */
    @Test
    void test1(){
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User user = sqlSession.selectOne("top.itlq.mybatis.learning.dao.xml.UserMapper.loadUser",1);
            System.out.println(user);
            // 映射
            top.itlq.mybatis.learning.dao.xml.UserMapper userMapper = sqlSession.getMapper(top.itlq.mybatis.learning.dao.xml.UserMapper.class);
            System.out.println(userMapper.loadUser(1));
        }finally {
            sqlSession.close();
        }
    }

    @Test
    void test11(){
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<User> users = sqlSession.selectList("top.itlq.mybatis.learning.dao.xml.UserMapper.selectUser",new LinkedHashMap<>(){{
                put("name","test2");
            }});
            System.out.println(users);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    void test12(){
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        // 默认 openSession 不主动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User user  = new User();
            user.setBirth(Instant.now());
            int insertResult = sqlSession.insert("top.itlq.mybatis.learning.dao.xml.UserMapper.insert", user);
            System.out.println(user);
            // 默认 openSession 不主动提交，需手动提交或创建时传 true
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    void test13(){
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        // 默认 openSession 不主动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User user = sqlSession.<User>selectList("top.itlq.mybatis.learning.dao.xml.UserMapper.selectWithFavorites",
                    new HashMap<String,Object>(){{ put("id", 1); }}).get(0);
            System.out.println(user);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    void test14(){
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        // 默认 openSession 不主动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<User> users = sqlSession.<User>selectList("top.itlq.mybatis.learning.dao.xml.UserMapper.selectWithJoinFavorites",
                    new HashMap<String,Object>(){{ put("id", null); }});
            System.out.println(users);
        }finally {
            sqlSession.close();
        }
    }

    /**
     * sql语句注解接口形式
     */
    @Test
    void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryWithJava();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectUserWithInterface(1);
            System.out.println(user);
        }finally {
            sqlSession.close();
        }
    }
}
