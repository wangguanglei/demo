package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 拦截某个请求跳转固定位置
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) { ;
        registry.addViewController("/").setViewName("upload");
        registry.addViewController("/upload.html").setViewName("upload");
    }
}