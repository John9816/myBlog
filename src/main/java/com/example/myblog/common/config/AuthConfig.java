package com.example.myblog.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 权限验证过滤
 */
@Configuration
public class AuthConfig implements WebMvcConfigurer {

    @Bean
    public AuthInterceptor initAuthInterceptor(){
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(initAuthInterceptor())
                .addPathPatterns("/article/**", "/user/**", "file/**")//拦截
                .excludePathPatterns("/user/login");//放行
    }
}
