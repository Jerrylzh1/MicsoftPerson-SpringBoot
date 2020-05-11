package org.javaboy.vhr.config;

import org.javaboy.vhr.model.Menu;
import org.javaboy.vhr.model.Role;
import org.javaboy.vhr.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/5/10 21:12
 * 进行登录用户的菜单权限控制  根据用户传来的请求地址分析请求需要的角色
 * FilterInvocationSecurityMetadataSource 为可受保护的
 *
 * 注册为一个组件
 */
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    IMenuService menuService;
    AntPathMatcher antPathMatcher=new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取请求的路径地址
        String requestUrl=((FilterInvocation) object).getRequestUrl();
        //获取所有的菜单menu和角色
        List<Menu> menus=menuService.getAllMenusWithRole();
         for (Menu menu:menus){
            //将请求地址和menu的path地址进行匹配
            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
                List<Role> roles=menu.getRoles();
                String[] str=new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    str[i]=roles.get(i).getName();
                }
                //利用的是Security自带的createList 封装menu对应的角色
                return SecurityConfig.createList(str);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
