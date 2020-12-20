package com.example.demo.util.shiro;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.util.jwt.JWTToken;
import com.example.demo.util.jwt.JWTUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean supports(AuthenticationToken token){
        return token instanceof JWTToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
        String userName= (String) token.getPrimaryPrincipal();
        var info=new SimpleAuthorizationInfo();

        if (userName.equals("lpj")){
            info.addRole("admin");
            info.addStringPermission("create");
        }else{
            info.addRole("user");
            info.addStringPermission("query");
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName= (String) token.getPrincipal();
        String pwd= (String) token.getCredentials();
        if (userName==null)
            throw new UnknownAccountException("username cannot be null");

        if (userName.equals("lpj"))
            return new SimpleAuthenticationInfo("lpj","123",ShiroRealm.class.getName());
        else if (userName.equals("jerry"))
            return new SimpleAuthenticationInfo("jerry","456",ShiroRealm.class.getName());
        else
            return null;
    }
}
