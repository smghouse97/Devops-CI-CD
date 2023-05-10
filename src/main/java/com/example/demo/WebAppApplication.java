package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WebAppApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebAppApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebAppApplication.class, args);
    }

    // @RestController
    // public static class WebAppController {

    //     @GetMapping("/hello")
    //     public String hello() {
    //         return "<h1 style=\"color: hotpink; font-size: 40px; font: cursive;\"> Congratulations! You've successfully implemented the CI/CD pipeline and deployed a Java web application to AWS EC2 using Docker!</h1>";
    //     }
    // }
}
