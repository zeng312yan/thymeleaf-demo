package com.cn.service.impl;

import com.cn.mapper.UserMapper;
import com.cn.model.pojo.Permission;
import com.cn.model.pojo.UserPojo;
import com.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/7/9 16:25
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserPojo queryUserByUsername(String username) {

        return userMapper.queryUserByUsername(username);
    }

    @Override
    public Permission queryPermissionByUsername(String username) {
        return userMapper.queryPermissionByUsername(username);
    }
}
