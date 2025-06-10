package org.example;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("-- Thread Example using Thread Class --");


        ThreadExample thread1 = new ThreadExample();
        ThreadExample thread2 = new ThreadExample();

        thread1.start();
        thread2.start();

        System.out.println("-- Thread Example using Runnable interface --");

        RunnableExample runnableExample = new RunnableExample();
        Thread thread3 = new Thread(runnableExample);
        Thread thread4 = new Thread(runnableExample);

        thread3.start();
        thread4.start();

        ExecutorService singleService = Executors.newSingleThreadExecutor();
        long start = System.currentTimeMillis();
        for (int i=0; i< 10000; i++){
            singleService.execute(new Task(i));
        }
        singleService.shutdown();

        System.out.println("-- Executor new Fixed Thread Pool --");
        ExecutorService fixedService = Executors.newFixedThreadPool(10);
        for (int i=0; i< 1000000; i++){
            fixedService.execute(new Task(i));
        }
        fixedService.shutdown();

        System.out.println("-- Executor new Cached Thread Pool --");
        ExecutorService cachedService = Executors.newCachedThreadPool();
        for (int i=0; i< 1000000; i++){
            cachedService.execute(new Task(i));
        }
        cachedService.shutdown();

    }
}