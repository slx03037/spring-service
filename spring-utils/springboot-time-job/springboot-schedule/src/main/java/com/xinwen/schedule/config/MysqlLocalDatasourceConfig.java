package com.xinwen.schedule.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-10 21:55
 **/
@MapperScan(basePackages = MysqlLocalDatasourceConfig.PACKAGE,sqlSessionFactoryRef="mysqlLocalSqlSessionFactory")
@Configuration
public class MysqlLocalDatasourceConfig {
    //数据源配置的 prod 扫描的路径
    static final  String PACKAGE="com.xinwen.schedule.mapper.local";
    //mybatis mapper扫描路径
    static final String MAPPER_LOCATION = "classpath*:mapper/local/*.xml";

    @Primary
    @Bean(name = "mysqlLocalDatasource")
    @ConfigurationProperties("spring.datasource.druid.local")
    public DataSource mysqlDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlLocalTransactionManager")
    @Primary
    public DataSourceTransactionManager mysqlTransactionManager() {
        return new DataSourceTransactionManager(mysqlDataSource());
    }

    @Bean(name = "mysqlLocalSqlSessionFactory")
    @Primary
    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlLocalDatasource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        //如果不使用xml的方式配置mapper，则可以省去下面这行mapper location的配置。
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(MysqlLocalDatasourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}
