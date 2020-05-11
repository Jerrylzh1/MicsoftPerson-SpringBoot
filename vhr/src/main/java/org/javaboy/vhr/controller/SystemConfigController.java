package org.javaboy.vhr.controller;

import org.javaboy.vhr.model.Menu;
import org.javaboy.vhr.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/4/29 21:45
 */
@RestController
@RequestMapping("/api/system")
@CrossOrigin
public class SystemConfigController {

    @Autowired
    IMenuService menuService;

    @GetMapping("/menu")
    public List<Menu> findMenu(){
        return menuService.findMenu();
    }
}
