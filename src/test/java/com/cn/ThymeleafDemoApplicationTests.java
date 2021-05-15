package com.cn;

import com.cn.mapper.UserMapper;
import com.cn.model.pojo.Permission;
import com.cn.model.pojo.UserPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThymeleafDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

//        final String admin = userMapper.test("admin");
//        System.out.println(admin);

//        final UserPojo admin = userMapper.queryUserByUsername("admin");
//        System.out.println(admin);

        final Permission permission = userMapper.queryPermissionByUsername("admin");
        System.out.println(permission);
    }

}
