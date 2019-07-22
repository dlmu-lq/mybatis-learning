package top.itlq.mybatis.learning.tests;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import top.itlq.mybatis.learning.dao.User;

import java.io.InputStream;

public class TestMybatis {
    @Test
    void test1(){
        InputStream is = TestMybatis.class.getResourceAsStream("/mybatis-conf.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("top.itlq.mybatis.learning.dao.UserMapper.selectUser",1);
        System.out.println(user);
        sqlSession.close();
    }
}
