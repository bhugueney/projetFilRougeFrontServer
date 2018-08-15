package com.myIGCoach.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Value( "${spring.resources.static-locations}" )
    private String DIRECTORY;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	System.out.println("Servicing from " + "file:" + DIRECTORY + "/");
        registry.addResourceHandler("/**") // 1
                .addResourceLocations("file:" + DIRECTORY + "/"); // 2
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
    }
}