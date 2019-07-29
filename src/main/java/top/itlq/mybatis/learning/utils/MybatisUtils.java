package top.itlq.mybatis.learning.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
    public static SqlSessionFactory sqlSessionFactory(){
        return new SqlSessionFactoryBuilder()
                .build(
                        MybatisUtils.class.getClassLoader()
                                .getResourceAsStream("mybatis-conf.xml")
                );
    }
}
