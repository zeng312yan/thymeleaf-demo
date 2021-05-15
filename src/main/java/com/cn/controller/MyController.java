package com.cn.controller;

import com.cn.model.Course;
import com.cn.model.Student;
import com.cn.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/4/11 0011 13:25
 * @Version 1.0
 */
@Controller
public class MyController {

    @RequestMapping("/test")
    public String test(Model model) {

        String hello="<h1>Hello Thymeleaf<h1>";
        model.addAttribute("hello",hello);


        final Course course = new Course();
        course.setName("语文");
        course.setTeacher("李老师");

        Student student = new Student();
        student.setAge(14);
        student.setCourse(course);
        student.setName("王浩");

        model.addAttribute("student",student);


        final User user1 = new User();
        user1.setAge(13);
        user1.setNickName("飞翔的企鹅");

        User user2 = new User();
        user2.setNickName("伤心小男孩");
        user2.setAge(25);
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);

        model.addAttribute("userList",list);

        return "test";

    }


}
