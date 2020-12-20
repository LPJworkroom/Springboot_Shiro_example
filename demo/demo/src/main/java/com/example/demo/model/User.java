package com.example.demo.model;

public class User extends CRUDModel{
    private String name;
    private String principle;
    private String pw_hash;
    private String salt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrinciple() {
        return principle;
    }

    public void setPrinciple(String principle) {
        this.principle = principle;
    }

    public String getPw_hash() {
        return pw_hash;
    }

    public void setPw_hash(String pw_hash) {
        this.pw_hash = pw_hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User(String name, String principle, String pw_hash, String salt) {
        this.name = name;
        this.principle = principle;
        this.pw_hash = pw_hash;
        this.salt = salt;
    }

    public User(int id, boolean isDeleted, String name, String principle, String pw_hash, String salt) {
        super(id, isDeleted);
        this.name = name;
        this.principle = principle;
        this.pw_hash = pw_hash;
        this.salt = salt;
    }
}
