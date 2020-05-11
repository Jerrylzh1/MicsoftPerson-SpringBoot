package org.javaboy.vhr.service;

import org.javaboy.vhr.model.Menu;

import java.util.List;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/4/29 21:47
 */
public interface IMenuService {
    List<Menu> findMenu();
    List<Menu> getAllMenusWithRole();
}
