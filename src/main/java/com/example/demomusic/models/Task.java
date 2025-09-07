package com.example.demomusic.models;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

    @Override
    public String call() {
        try {
            Thread.sleep(100);
            return "Execution task in thread " + Thread.currentThread().getName();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
