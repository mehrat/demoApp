package com.example.demomusic.controller;

import com.example.demomusic.entity.HelloRequest;
import com.example.demomusic.services.HelloService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @Operation(summary = "Returns a Hello World message")
    @PostMapping("/hello")
    public ResponseEntity<String> hello(@Valid @RequestBody HelloRequest helloRequest) {
        return ResponseEntity.ok().body(helloService.greetings(helloRequest.getName()));
    }
}
