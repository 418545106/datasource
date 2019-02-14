package com.yq.data.source.controller;

import com.yq.data.source.po.UserInfo;
import com.yq.data.source.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auther: zpd
 * @Date: 2019/2/12 0012 13:15
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userServiceImpl;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 返回db1所有用户信息
     * @return
     */
    @GetMapping("/db1/user")
    public List<UserInfo> getdb1AllUser(){
        List<UserInfo> users = userServiceImpl.getdb1AllUser();
        return users;
    }

    /**
     * 返回db1所有用户信息
     * @return
     */
    @GetMapping("/db2/user")
    public List<UserInfo> getdb2AllUser(){
        List<UserInfo> users = userServiceImpl.getdb2AllUser();
        return users;
    }
}
