package com.cy.practice1_store.service.controller;

import com.cy.practice1_store.service.ex.InsertException;
import com.cy.practice1_store.service.ex.ServiceException;
import com.cy.practice1_store.service.ex.UsernameDuplicatedException;
import com.cy.practice1_store.service.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 86152
 */
public class BaseController {

    public static final int OK = 200;

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if(e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名被占用");
        }else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("未知异常");
        }
        return result;
    }
}
