package com.lpjworkroom.new_buddyoj_backend.dao;

import com.lpjworkroom.new_buddyoj_backend.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getByName(String name);
    int create(User user);
}
