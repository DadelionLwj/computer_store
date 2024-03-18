package com.cy.practice1_store.service.controller;

import com.cy.practice1_store.entity.User;
import com.cy.practice1_store.service.IUserService;
import com.cy.practice1_store.service.ex.InsertException;
import com.cy.practice1_store.service.ex.UsernameDuplicatedException;
import com.cy.practice1_store.service.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 86152
 * RestController是Controller和ResponseBody的集合
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<>(OK);
    }
}
