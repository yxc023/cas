package com.lianjia.commerce.meima;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.Factory;
import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.pac4j.cas.client.CasClient;
import org.pac4j.cas.config.CasConfiguration;
import org.pac4j.core.authorization.authorizer.RequireAnyRoleAuthorizer;
import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.context.session.J2ESessionStore;
import org.pac4j.core.context.session.SessionStore;
import org.pac4j.core.credentials.TokenCredentials;
import org.pac4j.core.exception.HttpAction;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.creator.ProfileCreator;
import org.pac4j.springframework.web.SecurityInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;

/**
 * @author: yangxiaochen
 * Date: 2017-12-28
 */
@Configuration
//@ComponentScan(basePackages = "org.pac4j.springframework.web")
public class CasConfig extends WebMvcConfigurerAdapter {

    public static class User extends CommonProfile {

    }

//    @Bean
//    public Config config() {
//
//        final CasConfiguration configuration = new CasConfiguration("http://passport.dev.lianjia.com:8088/cas/login");
//        final CasClient casClient = new CasClient(configuration);
//        casClient.setProfileCreator(new ProfileCreator<TokenCredentials, CommonProfile>() {
//            @Override
//            public CommonProfile create(TokenCredentials credentials, WebContext context) throws HttpAction {
//                CommonProfile commonProfile = credentials.getUserProfile();
//                CommonProfile profile = new User();
//                profile.addAttributes(commonProfile.getAttributes());
//                return profile;
//            }
//        });
//
//
//        final Clients clients = new Clients("http://workflow.dev.lianjia.com:8080/callback", casClient);
//
//        final Config config = new Config(clients);
//        config.setSessionStore(new J2ESessionStore());
//        config.addAuthorizer("admin", new RequireAnyRoleAuthorizer("ROLE_ADMIN"));
////        config.addAuthorizer("custom", new CustomAuthorizer());
//        return config;
//    }




    @Bean
    public FilterRegistrationBean shiroFilter() throws Exception {
//        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//        SecurityManager securityManager = factory.getInstance();
//        SecurityUtils.setSecurityManager(securityManager);
//        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        ShiroFilter shiroFilter = new ShiroFilter();
//        filterFactoryBean.setSecurityManager(securityManager);
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(shiroFilter);
        bean.addUrlPatterns("/*");
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean shiroListener() {
        EnvironmentLoaderListener environmentLoaderListener = new EnvironmentLoaderListener();
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean(environmentLoaderListener);
        return registrationBean;
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new SecurityInterceptor(config(), "CasClient")).addPathPatterns("/index");
//    }
}
