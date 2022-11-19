package com.example.earthspring51;

import com.example.out.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Supplier;

@SpringBootApplication
public class Earthspring51Application {

    @Autowired
    MyService myService;

    public static void main(String[] args) {
//        SpringApplication.run(Earthspring51Application.class, args);
        var app = new SpringApplication(Earthspring51Application.class);
        app.addInitializers((ApplicationContextInitializer<GenericApplicationContext>) ctx -> {
            ctx.registerBean(MyService.class);
            ctx.registerBean(ApplicationRunner.class, () -> args1 -> System.out.println("Funational Bean Defination!!"));
        }); //성능 상의 이점 존재
        app.run(args);
    }

}
