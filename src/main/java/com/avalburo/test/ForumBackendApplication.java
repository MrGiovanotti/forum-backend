package com.avalburo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.avalburo.test.services.ForumService;

@SpringBootApplication
public class ForumBackendApplication implements CommandLineRunner {

    @Autowired
    ForumService forumService;

    public static void main(String[] args) {
	SpringApplication.run(ForumBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
	// To test my code
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
	    }
	};
    }

}
