package com.cn.controller;

import com.cn.model.pojo.UserPojo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Administrator
 * @Date 2021/4/11 0011 22:31
 * @Version 1.0
 */
@Controller
public class UserController {

    @RequestMapping("/user/queryAll")
    @ResponseBody
    public String queryAll(){
        return "这是 user/queryAll方法";
    }


    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request){
        UserPojo user = new UserPojo();
        user.setUsername(username);
        user.setPassword(password);

        // 创建出一个 Token 内容本质基于前台的用户名和密码（不一定正确）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 获取 subject 认证主体（这里也就是现在登录的用户）
        Subject subject = SecurityUtils.getSubject();
        if(subject == null){
            return "views/login";
        }
        try {
            // 认证开始，这里会跳转到自定义的 UserRealm 中
            subject.login(token);
            // 可以存储到 session 中
            request.getSession().setAttribute("user",user);
            return "views/success";
        }catch (Exception e){
            // 捕获异常
            e.printStackTrace();
            request.getSession().setAttribute("user", user);
            request.setAttribute("errorMsg", "兄弟，用户名或密码错误");
            return "views/login";
        }
    }
}
