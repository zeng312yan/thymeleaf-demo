package com.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Administrator
 * @Date 2021/4/11 0011 15:47
 * @Version 1.0
 */
@Controller
public class PageController {

    @RequestMapping({"/","index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/about")
    public String toAboutAge(){
        return "redirect:http://www.ideal-20.cn";
    }

    @RequestMapping("/toLoginPage")
    public String toLoginPage(){
        return "views/login";

    }

    @RequestMapping("/levelA/{name}")
    public String toLevelAPage(@PathVariable("name") String name){
        return "views/L-A/"+name;
    }

    @RequestMapping("/levelB/{name}")
    public String toLevelBPage(@PathVariable("name") String name) {
        return "views/L-B/" + name;
    }

    @RequestMapping("/levelC/{name}")
    public String toLevelCPage(@PathVariable("name") String name) {
        return "views/L-C/" + name;
    }

    @RequestMapping("/unauthorized")
    public String toUnauthorizedPage() {
        return "views/unauthorized";
    }

    @RequestMapping("/success")
    public String toSuccessPage() {
        return "views/success";
    }

}
