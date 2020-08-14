package com.dync.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liujipeng
 * @date 2020/6/16 16:29
 * @mail liujipeng@cloud-er.com
 * @desc ...
 */
@Configuration
//@MapperScan(basePackages = "com.example.dongtai.mapper") // mybitas 配置
public class DateSourceConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDb(){
        DruidDataSource build = DruidDataSourceBuilder.create().build();
        return build;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDb(){
        DruidDataSource build = DruidDataSourceBuilder.create().build();
        return build;
    }

    @Bean
    public DynamicDataSource dynamicDb(@Qualifier("masterDb") DataSource master, @Qualifier("slaveDb") DataSource slave){
        DynamicDataSource dataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(com.dync.util.DataSource.MASTER.getDesc(),master);
        targetDataSources.put(com.dync.util.DataSource.SLAVE1.getDesc(),slave);
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(slave);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("dynamicDb")DynamicDataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }


    @Bean
    public DataSourceTransactionManager manager(@Qualifier("dynamicDb")DynamicDataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }


/*
    //mybitas  配置

    @Bean
    public SqlSessionFactory sessionFactory(@Qualifier("dynamicDb")DynamicDataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath*:mapper/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate sql(@Qualifier("sessionFactory") SqlSessionFactory factory){
        return new SqlSessionTemplate(factory);
    }*/

}
