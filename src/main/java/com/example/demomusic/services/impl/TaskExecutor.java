package com.example.demomusic.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Service
public class TaskExecutor {

    @Autowired
    private ExecutorService myThreadPoolExecutor;

    @Autowired
    public TaskExecutor(ExecutorService myThreadPoolExecutor) {
        this.myThreadPoolExecutor = myThreadPoolExecutor;
    }

    public void executeTasks(List<String> orders) {

        List<Future<String>> futures = new ArrayList<>();
        for (String order : orders) {
            Future<String> submit = myThreadPoolExecutor.submit(() -> processOrder(order));
            futures.add(submit);
        }

        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private String processOrder(String order) {

        System.out.println("Processing order " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
            return "Order Processed " + order;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
