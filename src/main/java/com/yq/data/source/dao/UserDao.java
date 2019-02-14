package com.yq.data.source.dao;

import com.yq.data.source.po.UserInfo;

import java.util.List;

/**
 * @auther: zpd
 * @Date: 2019/2/12 0012 13:39
 * @Description:
 */
public interface UserDao {

    /**
     * 获取db1所有用户
     * @return
     */
    List<UserInfo> getdb1AllUser();

    /**
     * 获取db2所有用户
     * @return
     */
    List<UserInfo> getdb2AllUser();
}
