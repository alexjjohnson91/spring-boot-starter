package com.alexjohnson.SpringBootStarter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringBootStarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterApplication.class, args);
    }
}
