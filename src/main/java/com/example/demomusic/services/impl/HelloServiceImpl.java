package com.example.demomusic.services.impl;

import com.example.demomusic.services.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greetings(String name) {
        return "Hello " + name;
    }
}
