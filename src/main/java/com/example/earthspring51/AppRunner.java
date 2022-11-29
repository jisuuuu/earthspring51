package com.example.earthspring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
<<<<<<< HEAD
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

=======
import org.springframework.stereotype.Component;

>>>>>>> origin/master
@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

<<<<<<< HEAD
    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Environment environment = ctx.getEnvironment();
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));
=======
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("proto");

        System.out.println(ctx.getBean(Proto.class));
        System.out.println(ctx.getBean(Proto.class));
        System.out.println(ctx.getBean(Proto.class));

        System.out.println("single");

        System.out.println(ctx.getBean(Single.class));
        System.out.println(ctx.getBean(Single.class));
        System.out.println(ctx.getBean(Single.class));

        System.out.println("proto by single");// proto를 proxy로 감싸서 바로 사용하지 못하도록, class 기반 proxy로 만들어서 사용

        System.out.println(ctx.getBean(Single.class).getProto());
        System.out.println(ctx.getBean(Single.class).getProto());
        System.out.println(ctx.getBean(Single.class).getProto());
>>>>>>> origin/master
    }
}
