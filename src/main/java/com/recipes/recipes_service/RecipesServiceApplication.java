package com.recipes.recipes_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class RecipesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipesServiceApplication.class, args);
    }


    @Configuration
    @EnableWebMvc
    public class WebMVCConfig implements WebMvcConfigurer {
        // Implement configuration methods...
    }
}
