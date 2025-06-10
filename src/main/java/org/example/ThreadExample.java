package org.example;

public class ThreadExample extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread Example Loop : "+ i + " - " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
