package top.itlq.mybatis.learning.utils;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import top.itlq.mybatis.learning.dao.in.UserMapper;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class MybatisUtils {
    public static SqlSessionFactory sqlSessionFactory(){
        return new SqlSessionFactoryBuilder()
                .build(
                        MybatisUtils.class.getClassLoader()
                                .getResourceAsStream("mybatis-conf.xml")
                );
    }

    /**
     * 不用 xml 配置文件创建
     * @return
     */
    public static SqlSessionFactory sqlSessionFactoryWithJava() throws IOException {
        // 数据库连接信息
        Properties properties = new Properties();
        properties.load(MybatisUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        // 工厂模式创建数据源 POOLED
        DataSourceFactory dataSourceFactory = new PooledDataSourceFactory();
        dataSourceFactory.setProperties(properties);
        DataSource dataSource = dataSourceFactory.getDataSource();
        // Builder 模式创建环境
        Environment environment = new Environment.Builder("development")
                .dataSource(dataSource)
                .transactionFactory(new JdbcTransactionFactory())
                .build();
        Configuration configuration = new Configuration(environment);
        // 可配置别名
//        configuration.getTypeAliasRegistry().registerAlias();
        configuration.addMapper(UserMapper.class);
        return new SqlSessionFactoryBuilder().build(configuration);
    }
}
