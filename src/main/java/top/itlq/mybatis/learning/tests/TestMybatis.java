package top.itlq.mybatis.learning.tests;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import top.itlq.mybatis.learning.dao.User;
import top.itlq.mybatis.learning.dao.in.UserMapper;

import static top.itlq.mybatis.learning.utils.MybatisUtils.sqlSessionFactory;

public class TestMybatis {
    /**
     * xml形式
     */
    @Test
    void test1(){
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User user = sqlSession.selectOne("top.itlq.mybatis.learning.dao.xml.UserMapper.selectUser",1);
            System.out.println(user);
        }finally {
            sqlSession.close();
        }
    }
    /**
     * sql语句注解接口形式
     */
    @Test
    void test(){
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
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
