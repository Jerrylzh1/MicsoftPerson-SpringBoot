package org.javaboy.vhr.model;

import lombok.Data;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/4/9 20:40
 */
@Data
public class RespBean {
    private Integer code;
    private String msg;
    private Object obj;

    public RespBean(){

    }

    public static RespBean ok(String msg){
        return new RespBean(200,msg,null);
    }

    public static RespBean ok(String msg,Object obj){
        return new RespBean(200,msg,obj);
    }

    public static RespBean error(String msg){
        return new RespBean(500,msg,null);
    }


    public static RespBean error(String msg,Object obj){
        return new RespBean(500,msg,obj);
    }

    public RespBean(Integer code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }
}
