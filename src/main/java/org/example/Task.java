package org.example;

public class Task implements Runnable{

    private int taskId;

    public Task(int i) {
        this.taskId = i;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task is " + taskId + " running by Thread "+ Thread.currentThread().getName());
    }
}
