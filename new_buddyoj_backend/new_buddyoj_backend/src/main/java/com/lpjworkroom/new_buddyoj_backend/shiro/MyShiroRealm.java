package com.lpjworkroom.new_buddyoj_backend.shiro;

import com.lpjworkroom.new_buddyoj_backend.model.User;
import com.lpjworkroom.new_buddyoj_backend.service.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm{
    Logger logger= LoggerFactory.getLogger(MyShiroRealm.class);

    @Resource
    LoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username= (String) principals.getPrimaryPrincipal();
        User user=loginService.getUserByName(username);
        logger.info(String.valueOf(user));
        var simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles((user.getRoles()));
        simpleAuthorizationInfo.addStringPermissions(user.getPermissions());

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (token==null)
            return null;
        String username= (String) token.getPrincipal();
        User user=loginService.getUserByName(username);
        if (user==null){
            return null;
        }else{
            return new SimpleAuthenticationInfo(username,user.getPassword(),
                    MyShiroRealm.class.getName());
        }
    }
}
