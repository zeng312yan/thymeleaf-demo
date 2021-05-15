package com.cn.model.pojo;

import lombok.Data;
import lombok.ToString;


/**
 * @Author Administrator
 * @Date 2021/4/11 0011 15:57
 * @Version 1.0
 */
@Data
@ToString
public class UserPojo {

    private int id;
    private String username;
    private String password;
    private Role role;
}
