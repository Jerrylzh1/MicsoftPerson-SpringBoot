package org.javaboy.vhr.service.ServiceImpl;

import org.javaboy.vhr.mapper.MenuMapper;
import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.model.Menu;
import org.javaboy.vhr.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.List;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/4/29 21:48
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> findMenu() {
        //return menuMapper.findMenu((Hr)SecurityContextHolder.getContext().getAuthentication().getPrincipal().getId());
        //return menuMapper.findMenu(12);
        return menuMapper.findMenu(((Hr)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

//    @Cacheable
    @Override
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }
}
