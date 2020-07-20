package org.javaboy.vhr.service.ServiceImpl;

import org.javaboy.vhr.mapper.MenuMapper;
import org.javaboy.vhr.mapper.MenuRoleMapper;
import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.model.Menu;
import org.javaboy.vhr.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/4/29 21:48
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private MenuRoleMapper menuRoleMapper;

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

    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    /**
     * 根据 Rid进行获取菜单
     * @param rid
     * @return
     */
    @Override
    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }

    //进行更新权限组菜单选项
    @Override
    public boolean updateMenuRole(Integer rid, Integer[] mids) {

        //先进行对应id删除菜单选项
        menuRoleMapper.deleteByRId(rid);
        if (mids==null || mids.length==0){
            return true;
        }
        //进行插入菜单选项
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        return result==mids.length;

    }
}
