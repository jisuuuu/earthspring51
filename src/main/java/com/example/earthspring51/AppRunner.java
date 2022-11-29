package com.example.earthspring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    ApplicationEventPublisher publishEvent;

    @Autowired
    MessageSource messageSource;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    BookRepository bookRepository;

    @Value("${app.name}")
    String appName;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Environment environment = ctx.getEnvironment();
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));

        System.out.println(environment.getProperty("app.name")); //Edit Spring 등록
        System.out.println("appName = " + appName);

        System.out.println(messageSource.getMessage("greeting", new String[]{"jisu"}, Locale.KOREA));
        System.out.println(messageSource.getMessage("greeting", new String[]{"jisu"}, Locale.US));

        publishEvent.publishEvent(new MyEvent(this, 100));

        Resource resource = resourceLoader.getResource("classpath:test.txt");
        System.out.println(resource.exists());
        System.out.println(resource.getDescription());
        System.out.println(Files.readString(Path.of(resource.getURI())));
    }
}
