package com.example.earthspring51;

import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class AnotherHandler {

    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE + 2)
    public void handle(MyEvent event) {
        System.out.println("이것도 실행됩니다~!" + event.getData());
    }
}
