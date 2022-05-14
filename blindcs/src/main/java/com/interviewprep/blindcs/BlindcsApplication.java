package com.interviewprep.blindcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
public class BlindcsApplication {

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello World1";
    }

    public static void main(String[] args) {
        SpringApplication.run(BlindcsApplication.class, args);


        Test1 t1 = new Test1();
        System.out.println(t1.test());
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Allows cross-origin http requests when developing on the local react frontend
                registry.addMapping("/**").allowedOrigins("http://localhost:3000");
            }
        };
    }
}


