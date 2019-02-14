package com.yq.data.source.service.impl;

import com.yq.data.source.annotation.DataBase;
import com.yq.data.source.dao.UserDao;
import com.yq.data.source.po.UserInfo;
import com.yq.data.source.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther: zpd
 * @Date: 2019/2/12 0012 13:27
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<UserInfo> getdb1AllUser() {
        List<UserInfo> users = userDao.getdb1AllUser();
        return users;
    }

    @DataBase("db2")
    @Override
    public List<UserInfo> getdb2AllUser() {
        List<UserInfo> users = userDao.getdb2AllUser();
        return users;
    }
}