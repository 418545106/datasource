package com.yq.data.source.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther: zpd
 * @Date: 2019/2/12 0012 09:39
 * @Description:
 */
@Configuration
public class DataSourceConfig {

    /**
     * db1数据源配置
     * @return
     */
    @Bean("db1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource db1Source(){
        return DataSourceBuilder.create().build();
    }

    /**
     * db2数据源配置
     * @return
     */
    @Bean("db2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource db2Source(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //默认数据源
        dynamicDataSource.setDefaultTargetDataSource(db1Source());

        //配置多数据源
        Map<Object,Object> dsMap = new HashMap<>(5);
        dsMap.put("db1",db1Source());
        dsMap.put("db2",db2Source());

        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解事务
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
