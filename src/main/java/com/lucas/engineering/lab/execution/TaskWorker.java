package com.lucas.engineering.lab.execution;

import java.util.Objects;

import com.lucas.engineering.lab.task.Task;

public class TaskWorker implements Runnable {
    private final TaskQueue queue;
    private final TaskExecutor executor;

    public TaskWorker(TaskQueue queue, TaskExecutor executor) {
        this.queue = Objects.requireNonNull(queue);
        this.executor = Objects.requireNonNull(executor);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Task task = queue.take();
                executor.execute(task);

            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
