package com.example.earthspring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @PostConstruct
    public void setUp() {
        System.out.println("bookRepository.getClass() = " + bookRepository.getClass());
    }
}
