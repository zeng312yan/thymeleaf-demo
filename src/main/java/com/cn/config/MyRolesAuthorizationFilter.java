package com.cn.config;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author Administrator
 * @Date 2021/4/18 0018 13:01
 * @Version 1.0
 */
public class MyRolesAuthorizationFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request,
                                      ServletResponse response,
                                      Object mapperValue) throws Exception {
        Subject subject = getSubject(request, response);

        return false;
    }
}
