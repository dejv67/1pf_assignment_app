package com.davidkral.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // nebo /** pro všechny endpointy
                .allowedOrigins("http://localhost:5173") // odkud může frontend přistupovat
                .allowedMethods("GET") // povolené metody
                .allowedHeaders("*"); // povolené hlavičky
                //.allowCredentials(true); // pokud chceš posílat cookies/tokeny
    }
}
