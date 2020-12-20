package com.lpjworkroom.new_buddyoj_backend.service;

import com.lpjworkroom.new_buddyoj_backend.model.User;

public interface LoginService {
    int addUser(User user);
    User getUserByName(String name);
}
