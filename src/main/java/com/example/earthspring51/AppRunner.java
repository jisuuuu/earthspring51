package com.example.earthspring51;

import com.fasterxml.jackson.core.JsonToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {

    @Value("#{1 + 1}")
    int value;

    @Value("#{'hello' + 'world'}")
    String greeting;

    @Value("#{1 eq 1}")
    boolean trueOrFalse;

    @Value("Hello")
    String hello;

    @Value("${my.value}")
    int myValue;

    @Value("#{${my.value} eq 101}")
    boolean isMyValue101;

    @Value("#{sample.data}")
    int sampleData;

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

    @Autowired
    ConversionService conversionService;

    @Autowired
    EventService eventService;
    
    @Autowired
    StrangeEventService strangeEventService;

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

        System.out.println(resourceLoader.getClass());

        Event event = new Event(1);
        EventValidator eventValidator = new EventValidator();
        Errors errors = new BeanPropertyBindingResult(event, "evnet");

        eventValidator.validate(event, errors);

        System.out.println(errors.hasErrors());

        errors.getAllErrors().forEach(e -> {
            System.out.println("======= error code =======");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
        });

        System.out.println("conversionService.getClass().toString() = " + conversionService.getClass().toString());
        System.out.println(conversionService);

        System.out.println("================");
        System.out.println(value);
        System.out.println(greeting);
        System.out.println(trueOrFalse);
        System.out.println(hello);
        System.out.println(myValue);
        System.out.println(isMyValue101);
        System.out.println(sampleData);

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("2 + 100");
        Integer value = expression.getValue(Integer.class);
        System.out.println("value = " + value);

        eventService.createEvent();
        eventService.publishEvent();
        eventService.deleteEvent();

        String event1 = strangeEventService.createEvent(null);
    }
}
