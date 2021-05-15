package com.cn.model.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @Author Administrator
 * @Date 2021/4/11 0011 15:59
 * @Version 1.0
 */
@Data
@ToString
public class Permission {
    private int id;
    private String permissionName;
    private Role role;
}
