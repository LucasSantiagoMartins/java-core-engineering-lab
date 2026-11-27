package com.lucas.engineering.lab.execution;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TaskWorkerPool {
    private final TaskQueue queue;
    private final TaskExecutor taskExecutor;
    private final int workerCount;

    private ExecutorService executorService;

    public TaskWorkerPool(TaskQueue queue, TaskExecutor taskExecutor, int workerCount) {
        this.queue = Objects.requireNonNull(queue);
        this.taskExecutor = Objects.requireNonNull(taskExecutor);

        if (workerCount <= 0) {

            throw new IllegalArgumentException("Worker count must be greater than zero.");
        }

        this.workerCount = workerCount;
    }

    public synchronized void start() {
        if (executorService != null) {
            throw new IllegalStateException("Worker pool has already been started.");
        }

        executorService = Executors.newFixedThreadPool(workerCount);

        for (int i = 0; i < workerCount; i++) {
            TaskWorker worker = new TaskWorker(queue, taskExecutor);

            executorService.submit(worker);
        }
    }

    public synchronized void shutdown() {
        if (executorService != null) {
            executorService.shutdownNow();
        }
    }

    public synchronized boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        if (executorService == null)
            return true;

        return executorService.awaitTermination(timeout, unit);
    }
}
