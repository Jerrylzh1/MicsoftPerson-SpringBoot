package org.javaboy.vhr.exception;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.javaboy.vhr.model.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/5/13 21:24
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e){
        if (e instanceof MySQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有关联数据，不能够删除！");
        }
        return RespBean.error("数据库异常！");
    }
}
