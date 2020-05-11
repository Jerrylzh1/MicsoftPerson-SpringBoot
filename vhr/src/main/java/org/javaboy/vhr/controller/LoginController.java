package org.javaboy.vhr.controller;

import org.javaboy.vhr.model.RespBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/4/9 22:15
 */
@RestController
@RequestMapping("/api")
public class LoginController {
    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("请登录用户！");
    }
}
