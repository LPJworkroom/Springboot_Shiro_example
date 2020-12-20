package com.example.demo.util.jwt;

import org.apache.shiro.authc.AuthenticationToken;

public class JWTToken implements AuthenticationToken {
    private String token;
    private String expireAt;


    public JWTToken(String token) {
        this.token = token;
    }

    public JWTToken(String token, String expireAt) {
        this.token = token;
        this.expireAt = expireAt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
