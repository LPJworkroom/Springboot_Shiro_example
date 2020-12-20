package com.lpjworkroom.new_buddyoj_backend.model;

import java.util.List;
import java.util.Set;

public class User {
    private int id;
    private String username;
    private String password;
    private List<String> roles;
    private List<String> permissions;

    public User() {
    }

    public User(int id, String username, String password, List<String> roles, List<String> permissions) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", permissions=" + permissions +
                '}';
    }
}
