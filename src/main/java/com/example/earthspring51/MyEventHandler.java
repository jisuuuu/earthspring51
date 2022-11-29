package com.example.earthspring51;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler {

    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public void handle(MyEvent event) {
        System.out.println("이벤트 받았다. 데이터는 " + event.getData());
    }

    @EventListener
    public void handle(ContextRefreshedEvent event) {
        System.out.println("ContextRefreshedEvent");
    }

    @EventListener
    public void handle(ContextClosedEvent event) {
        System.out.println("ContextClosedEvent");
    }
}
