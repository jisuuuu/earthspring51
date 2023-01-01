package com.example.earthspring51;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class StrangeEventService {

    @NonNull
    public String createEvent(@NonNull String name) {
        return "Hello " + name;
    }
}
