package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.HrMapper;
import org.javaboy.vhr.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/4/7 23:39
 */
@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Hr hr=hrMapper.loadUserByUsername(userName);
        if (hr==null){
            throw new UsernameNotFoundException("用户名不能为空！");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

}
