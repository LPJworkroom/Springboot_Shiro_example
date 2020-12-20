package com.lpjworkroom.new_buddyoj_backend.controller;


import com.lpjworkroom.new_buddyoj_backend.model.User;
import com.lpjworkroom.new_buddyoj_backend.service.LoginService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.SecurityUtils;

import javax.annotation.Resource;

@RestController
public class LoginController {
    Logger logger= LoggerFactory.getLogger(LoginController.class.getName());

    @Resource
    private LoginService loginService;

    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public String login(@RequestBody User user){
        var usernamePasswordToken=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        SecurityUtils.getSubject().login(usernamePasswordToken);
        return "login ok!";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        loginService.addUser(user);
        return "add user ok!"+user;
    }

    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String create(){
        var subject=SecurityUtils.getSubject();
        logger.info((String)subject.getPrincipal()+" in create");
        if (subject.hasRole("admin"))
            logger.info("has role admin");
        else {
            logger.info("dont has role admin");
//            throw new AuthorizationException("dont have enough role");
        }

        if (subject.isPermitted("create"))
            logger.info("has permission create");
        else
            logger.info("dont has permission create");
        return "create success!";
    }

    @GetMapping(value = "/")
    public String nothing() {
        return "nothing here";
    }

    @GetMapping(value = "/index")
    public String index() {
        return "index page!";
    }

    @GetMapping(value = "/error")
    public String error() {
        return "error sdfsd page!";
    }

    @GetMapping(value = "/unauthorized")
    public String unauthorized(){
        return "unauthorized!";
    }
}
