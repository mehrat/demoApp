package com.example.demomusic.entity;

import jakarta.validation.constraints.NotNull;

public class HelloRequest {

    @NotNull
    private String name;

    public HelloRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
