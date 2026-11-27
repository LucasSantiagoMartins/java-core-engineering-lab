
package com.lucas.engineering.lab.execution;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.lucas.engineering.lab.task.Task;

import static org.junit.jupiter.api.Assertions.*;

class TaskWorkerPoolTest {

    @Test
    void shouldExecuteTasksConcurrently() throws Exception {

        TaskQueue queue = new TaskQueue();

        TaskExecutor taskExecutor = new TaskExecutor();

        int workerCount = 3;

        CountDownLatch startedTasks =
            new CountDownLatch(workerCount);

        CountDownLatch releaseTasks =
            new CountDownLatch(1);

        for (int i = 0; i < workerCount; i++) {

            Task task = new Task(
                "Task " + i,
                "Concurrent task",
                () -> {
                    startedTasks.countDown();

                    try {
                        releaseTasks.await();
                    } catch (InterruptedException exception) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(exception);
                    }
                }
            );

            queue.submit(task);
        }

        TaskWorkerPool pool = new TaskWorkerPool(
            queue,
            taskExecutor,
            workerCount
        );

        try {
            pool.start();

            boolean allStarted = startedTasks.await(
                3,
                TimeUnit.SECONDS
            );

            assertTrue(
                allStarted,
                "All tasks should start concurrently."
            );

        } finally {
            releaseTasks.countDown();
            pool.shutdown();

            assertTrue(
                pool.awaitTermination(3, TimeUnit.SECONDS)
            );
        }
    }

    @Test
    void shouldRejectZeroWorkers() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new TaskWorkerPool(
                new TaskQueue(),
                new TaskExecutor(),
                0
            )
        );
    }

    @Test
    void shouldRejectNegativeWorkerCount() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new TaskWorkerPool(
                new TaskQueue(),
                new TaskExecutor(),
                -1
            )
        );
    }

    @Test
    void shouldRejectStartingPoolTwice() {
        TaskWorkerPool pool = new TaskWorkerPool(
            new TaskQueue(),
            new TaskExecutor(),
            2
        );

        try {
            pool.start();

            assertThrows(
                IllegalStateException.class,
                pool::start
            );

        } finally {
            pool.shutdown();
        }
    }
}
