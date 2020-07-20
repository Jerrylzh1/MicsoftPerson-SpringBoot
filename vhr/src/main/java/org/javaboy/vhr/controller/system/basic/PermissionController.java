package org.javaboy.vhr.controller.system.basic;

import org.javaboy.vhr.model.Menu;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.Role;
import org.javaboy.vhr.service.IMenuService;
import org.javaboy.vhr.service.IPermissionService;
import org.javaboy.vhr.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/5/17 23:28
 */
@RestController
@RequestMapping("/system/basic/permission")
public class PermissionController {


    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private IMenuService menuService;
    //初始化roles
    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    //初始化菜单选项
    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    @GetMapping("/menus/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid) {
        return menuService.getMidsByRid(rid);
    }

    /**
     *
     * @param rid
     * @param mids
     * @return
     */
    @PutMapping
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    /**
     * 进行添加角色
     * @param role
     * @return
     */
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role) {
        if (roleService.addRole(role) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

}
