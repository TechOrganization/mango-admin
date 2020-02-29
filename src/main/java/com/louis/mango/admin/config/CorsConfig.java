package com.louis.mango.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName CorsConfig
 * @Description TODO
 * @Autgor huang
 * @Date 2020-02-22 17:47
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**") // 允许跨域
                .allowedOrigins("*") // 允许跨域访问源
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE") // 允许请求方法
                .maxAge(168000) // 预检间隔时间
                .allowedHeaders("*") // 允许头设置
                .allowCredentials(true); // 是否发送 cookie
    }
}
