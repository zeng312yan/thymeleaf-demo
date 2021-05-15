//package com.cn.config;
//
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.util.CollectionUtils;
//import org.apache.shiro.web.filter.authz.AuthorizationFilter;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import java.util.Set;
//
///**
// * @Author Administrator
// * @Date 2021/4/18 0018 12:30
// * @Version 1.0
// */
//public class RolesAuthorizationFilter extends AuthorizationFilter {
//    @Override
//    protected boolean isAccessAllowed(ServletRequest request,
//                                      ServletResponse response, Object mappedValues) throws Exception {
//
//        Subject subject = getSubject(request, response);
//        String[] rolesArray = (String[]) mappedValues;
//
//        if (rolesArray == null || rolesArray.length == 0) {
//            //no roles specified, so nothing to check - allow access.
//            return true;
//        }
//        Set<String> roles = CollectionUtils.asSet(rolesArray);
//
//        return subject.hasAllRoles(roles);
//    }
//}
