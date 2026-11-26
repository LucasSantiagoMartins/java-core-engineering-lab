package com.lucas.engineering.lab.execution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.lucas.engineering.lab.task.Task;
import com.lucas.engineering.lab.task.TaskRegistry;
import com.lucas.engineering.lab.task.TaskStatus;

class TaskSchedulerTest {

    private TaskScheduler createScheduler() {
        return new TaskScheduler(new TaskRegistry(), new TaskQueue(), new TaskExecutor());
    }

    @Test
    void shouldSubmitTask() {
        TaskScheduler scheduler = createScheduler();

        Task task = new Task(
                "Send Email",
                "Send welcome email",
                () -> {
                });

        assertTrue(scheduler.submit(task));
        assertEquals(1, scheduler.pendingTasksCount());
        assertEquals(1, scheduler.registeredTasksCount());
    }

    @Test
    void shouldExecuteNextTask() {
        TaskScheduler scheduler = createScheduler();

        Task task = new Task(
                "Send Email",
                "Send welcome email",
                () -> {
                });

        scheduler.submit(task);
        Optional<ExecutionResult> result = scheduler.executeNext();

        assertTrue(result.isPresent());
        assertEquals(TaskStatus.COMPLETED, result.orElseThrow().status());
        assertEquals(0, scheduler.pendingTasksCount());
    }

    @Test
    void shouldReturnEmptyWhenThereAreNoPendingTasks() {
        TaskScheduler scheduler = createScheduler();

        Optional<ExecutionResult> result = scheduler.executeNext();

        assertTrue(result.isEmpty());
        assertEquals(0, scheduler.pendingTasksCount());
    }

}
