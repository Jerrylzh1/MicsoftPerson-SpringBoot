package org.javaboy.vhr.service.ServiceImpl;

import org.javaboy.vhr.mapper.RoleMapper;
import org.javaboy.vhr.model.Role;
import org.javaboy.vhr.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/5/17 23:33
 */
@Service
public class RoleServiceImpl  implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    @Override
    public int addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        return roleMapper.insert(role);
    }
}
