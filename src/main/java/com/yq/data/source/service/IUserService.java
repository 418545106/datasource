package com.yq.data.source.service;

import com.yq.data.source.po.UserInfo;

import java.util.List;

/**
 * @auther: zpd
 * @Date: 2019/2/12 0012 13:26
 * @Description:
 */
public interface IUserService {

    /**
     * 获取db1所有用户信息
     * @return
     */
    List<UserInfo> getdb1AllUser();

    /**
     * 获取db2所有用户信息
     * @return
     */
    List<UserInfo> getdb2AllUser();
}
