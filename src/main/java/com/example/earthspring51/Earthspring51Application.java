package com.example.earthspring51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:/app.properties")
public class Earthspring51Application {

    public static void main(String[] args) {
        SpringApplication.run(Earthspring51Application.class, args);
    }

}
