package org.javaboy.vhr.service;

import org.javaboy.vhr.model.Role;

import java.util.List;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/5/17 23:32
 */
public interface IRoleService {
    List<Role> getAllRoles();

    int addRole(Role role);
}
