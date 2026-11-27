package com.lucas.engineering.lab.execution;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.lucas.engineering.lab.task.Task;

class TaskWorkerTest {

    @Test
    void shouldConsumeAndExecuteSubmittedTask() throws Exception {
        TaskQueue queue = new TaskQueue();
        TaskExecutor executor = new TaskExecutor();

        CountDownLatch executionLatch = new CountDownLatch(1);

        Task task = new Task(
                "Send Email",
                "Send welcome email",
                executionLatch::countDown);

        TaskWorker worker = new TaskWorker(
                queue,
                executor);

        ExecutorService workerExecutor = Executors.newSingleThreadExecutor();

        Future<?> workerFuture = workerExecutor.submit(worker);

        try {
            queue.submit(task);

            boolean executed = executionLatch.await(2, TimeUnit.SECONDS);
            assertTrue(executed);
        } finally {
            workerFuture.cancel(true);
            workerExecutor.shutdownNow();

            assertTrue(workerExecutor.awaitTermination(2, TimeUnit.SECONDS));
        }

    }
}
