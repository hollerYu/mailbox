package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jk.*")
public class EmailServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailServerApplication.class, args);
    }

}
