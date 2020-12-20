package com.lpjworkroom.new_buddyoj_backend.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public MyShiroRealm myShiroRealm(){
        return new MyShiroRealm();
    }

    @Bean
    public SecurityManager securityManager(){
        var defaultWebSecurityManager=new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myShiroRealm());
        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        var factoryBean=new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        Map<String,String> filterMap=new HashMap<String,String>();
        filterMap.put("/**","authc");
        filterMap.put("/logout","logout");
        filterMap.put("/unauthorized","anon");

        factoryBean.setLoginUrl("/login");
        factoryBean.setSuccessUrl("/index");
        // todo:unauthorizedUrl 未能生效，仍然自动导航至/error
        factoryBean.setUnauthorizedUrl("/unauthorized");
        factoryBean.setFilterChainDefinitionMap(filterMap);

        return factoryBean;
    }


    /*不加这个shiro注解就不生效*/
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /*todo: 不加这个@RequiresRoles注解就不生效。为什么？*/
    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }
}
