package com.example.demo.service.impl;

import com.example.demo.mapper.CRUDMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import com.example.demo.util.Pager;
import com.example.demo.util.ResponseMessage.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends CRUDServiceImpl {
    @Resource
    UserMapper userMapper;

    public UserServiceImpl() {
        this.crudMapper=userMapper;
    }
}
