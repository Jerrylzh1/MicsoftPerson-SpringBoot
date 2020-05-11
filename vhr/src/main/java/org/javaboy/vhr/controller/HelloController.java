package org.javaboy.vhr.controller;

import org.javaboy.vhr.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/4/7 23:48
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public RespBean hello(){
        return RespBean.ok("Hello security");
    }

    @GetMapping("/employee/basic/hello")
    public RespBean hello2(){
        return RespBean.ok("/employee/basic/hello");
    }

    @GetMapping("/employee/advanced/hello")
    public RespBean hello3(){
        return RespBean.ok("/employee/advanced/hello");
    }
}
