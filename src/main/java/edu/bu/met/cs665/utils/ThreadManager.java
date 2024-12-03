/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: ThreadManager.java
 * Description: This class is responsible for the Thread Manager.
 */
package edu.bu.met.cs665.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadManager {

    private static ExecutorService instance = null;
    private static final int DEFAULT_NUMBER_OF_THREADS = 8;
    List<Future<?>> futures = new ArrayList<Future<?>>();

    public ThreadManager() {
        instance = createInstance();
    }

    public static ExecutorService getInstance() {
        if (instance == null) {
            instance = createInstance();
        }
        return instance;
    }

    private static ExecutorService createInstance() {
        return Executors.newFixedThreadPool(DEFAULT_NUMBER_OF_THREADS);
    }

    public void addTask(Runnable task) {
        Future<?> future = instance.submit(task);
        futures.add(future);
    }

    public void shutdown() {
        instance.shutdown();
    }

    public Map<String, Integer> getCompletedTaskCount() {
        Integer total = -1; // Can change to -1 Because the first task is the Simulation
        Integer completed = 0;
        for (Future<?> future : futures) {
            total++;
            if (future.isDone()) {
                completed++;
            }
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("completed", completed);
        result.put("total", total);
        return result;
    }
}
