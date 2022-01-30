package com.videvik.appdatabase.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableAutoConfiguration
@Configuration
@CrossOrigin
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Value("http://localhost:4200")
    private String allowedOrigin;


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // TODO: inject depending on environment
        registry
                .addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedOrigins("http://localhost:4200")
                .allowCredentials(true)
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                .allowedMethods("GET", "POST", "PATCH", "PUT", "DELETE")
                .allowedHeaders("*")
                .maxAge(4800);
    }
}
