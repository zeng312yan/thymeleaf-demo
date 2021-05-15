package com.cn.model;

import lombok.Data;

/**
 * @Author Administrator
 * @Date 2021/4/11 0011 14:17
 * @Version 1.0
 */
@Data
public class Student {
    private String name;
    private Integer age;
    private Course course;
}
