package com.lucas.engineering.lab.execution;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.lucas.engineering.lab.task.Task;

public class TaskQueue {
    private final BlockingQueue<Task> tasks = new LinkedBlockingQueue<>();

    public void submit(Task task) {
        tasks.offer(task);
    }

    public Task take() throws InterruptedException {
        return tasks.take();
    }

    public Task poll() {
        return tasks.poll();
    }

    public Task peek() {
        return tasks.peek();
    }

    public int size() {
        return tasks.size();
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}
