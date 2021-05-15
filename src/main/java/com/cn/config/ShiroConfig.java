package com.cn.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2021/4/11 0011 22:14
 * @Version 1.0
 */
@Configuration
public class ShiroConfig {

    //1、shiroFilterFactoryBean
    /**
     * 配置 Shiro 过滤器
     * anon：无需认证，即可访问，也就是游客也可以访问
     * authc：必须认证，才能访问，也就是例如需要登录后
     * roles[xxx] ：比如拥有某种角色身份才能访问 ，注：xxx为角色参数
     * perms[xxx]：必须拥有对某个请求、资源的相关权限才能访问，注：xxx为权限参数
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        // 定义 shiroFactoryBean
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 关联 securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 自定义登录页面，如果登录的时候，就会执行这个请求，即跳转到登录页
        shiroFilterFactoryBean.setLoginUrl("/toLoginPage");
        // 指定成功页面
        shiroFilterFactoryBean.setSuccessUrl("/success");
        // 指定未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        // LinkedHashMap 是有序的，进行顺序拦截器配置
        Map<String, String> filterChainMap = new LinkedHashMap<>();

        // 配置可以匿名访问的地址，可以根据实际情况自己添加，放行一些静态资源等，anon 表示放行
        filterChainMap.put("/css/**", "anon");
        filterChainMap.put("/img/**", "anon");
        filterChainMap.put("/js/**", "anon");
        // 指定页面放行，例如登录页面允许所有人登录
        filterChainMap.put("/toLoginPage", "anon");
        // 以“/user/admin” 开头的用户需要身份认证，authc 表示要进行身份认证
        filterChainMap.put("/user/admin/**", "authc");
        // /user/admin/ 下的所有请求都要经过权限认证，只有权限为 user:[*] 的可以访问，也可以具体设置到 user:xxx
        filterChainMap.put("/user/admin/**", "perms[user:*]");

        // 配置注销过滤器
        filterChainMap.put("/logout", "logout");

        // 将Map 存入过滤器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }

    //2、DefaultWebSecurityManager
    /**
     * 配置安全管理器 SecurityManager
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        // 将自定义 Realm 加进来
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联 Realm
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    //3、Realm对象：自定义

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    /**
     * 整合 thymeleaf
     * @return
     */
    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}