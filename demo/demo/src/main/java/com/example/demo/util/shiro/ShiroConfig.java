package com.example.demo.util.shiro;


import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSessionStorageEvaluator;
import org.springframework.context.annotation.Bean;

public class ShiroConfig {

    @Bean
    public Realm getShiroRealm(){
        return new ShiroRealm();
    }

    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getShiroRealm());
        DefaultSubjectDAO subjectDAO=new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator sessionStorageEvaluator= new DefaultSessionStorageEvaluator();

        //session 不存东西
        sessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);

        return securityManager;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition filter= new DefaultShiroFilterChainDefinition();
        filter.addPathDefinition("/login","anon");
        filter.addPathDefinition("/unauthenticated","anon");
        filter.addPathDefinition("/not_permitted","anon");

        filter.addPathDefinition("/**","authc");
        return filter;
    }

    
}
