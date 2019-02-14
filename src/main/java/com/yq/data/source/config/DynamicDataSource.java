package com.yq.data.source.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @auther: zpd
 * @Date: 2019/2/12 0012 09:53
 * @Description:
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDB();
    }
}
