package org.javaboy.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/5/11 19:55
 *
 * 引用AccessDecisionManager
 */
@Component
public class CustomerDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        //获取所有的用户角色集合
        for (ConfigAttribute configAttribute:configAttributes){
            //进行获取角色集合
            String needRole = configAttribute.getAttribute();
            if ("ROLE_LOGIN".equals(needRole)){
                //通过认证为匿名登录 则认为为未登录操作
                if (authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("尚未登录，请登录！！");
                }else {
                    return;
                }
            }
            //获取当前用户的登录角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                //获取当前的登录角色中含有 菜单角色 允许访问
                if (authority.getAuthority().equals(needRole)){
                    return;
                }

            }
        }
        throw new AccessDeniedException("权限不足，请联系管理员！！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
