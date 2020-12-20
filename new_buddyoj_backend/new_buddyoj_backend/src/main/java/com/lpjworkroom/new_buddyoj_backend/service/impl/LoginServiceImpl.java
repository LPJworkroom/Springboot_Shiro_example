package com.lpjworkroom.new_buddyoj_backend.service.impl;

import com.lpjworkroom.new_buddyoj_backend.dao.UserMapper;
import com.lpjworkroom.new_buddyoj_backend.model.User;
import com.lpjworkroom.new_buddyoj_backend.service.LoginService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.create(user);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getByName(name);
    }
}
