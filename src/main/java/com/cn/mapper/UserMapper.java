package com.cn.mapper;

import com.cn.model.pojo.Permission;
import com.cn.model.pojo.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Administrator
 * @Date 2021/4/11 0011 16:12
 * @Version 1.0
 */
@Mapper
public interface UserMapper {

    UserPojo queryUserByUsername(@Param("username") String username);

    Permission queryPermissionByUsername(@Param("username") String username);

    String test(@Param("username") String username);
}
