package com.lucas.engineering.lab.execution;

import java.util.ArrayDeque;
import java.util.Queue;

import com.lucas.engineering.lab.task.Task;

public class TaskQueue {
    private final Queue<Task> tasks = new ArrayDeque<>();

    public void submit(Task task) {
        tasks.offer(task);
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
