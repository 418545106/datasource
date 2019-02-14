package com.yq.data.source.config;

/**
 * @auther: zpd
 * @Date: 2019/2/12 0012 09:54
 * @Description:
 */
public class DataSourceContextHolder {

    /**
     * default dataSource
     */
    public static final String DEFAULT_DS = "db1";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDB(String dbType){
        contextHolder.set(dbType);
    }

    public static String getDB(){
        return contextHolder.get();
    }

    public static void clearDB(){
        contextHolder.remove();
    }
}
