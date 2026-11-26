package com.lucas.engineering.lab.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.lucas.engineering.lab.execution.TaskQueue;

class TaskQueueTest {

    @Test
    void shouldSubmitTask() {
        TaskQueue queue = new TaskQueue();

        Task emailTask = new Task(
                "Send welcome email",
                "Send Email",
                () -> {
                });

        queue.submit(emailTask);

        assertEquals(1, queue.size());
    }

    @Test
    void shouldProcessTaskInFifoOrder() {
        TaskQueue queue = new TaskQueue();

        Task firstTask = new Task(
                "Send welcome email",
                "Send Email",
                () -> {
                });

        Task secondTask = new Task(
                "Send welcome email",
                "Send Email",
                () -> {
                });

        queue.submit(firstTask);
        queue.submit(secondTask);

        assertEquals(firstTask, queue.poll());
        assertEquals(secondTask, queue.poll());
        assertTrue(queue.isEmpty());
    }

    @Test
    void shouldReturnNullWhenQueueIsEmpty() {
        TaskQueue queue = new TaskQueue();

        assertNull(queue.poll());
        assertNull(queue.peek());
    }

    @Test
    void peekShouldNotRemoveTask() {

        TaskQueue queue = new TaskQueue();

        Task emailTask = new Task(
                "Send welcome email",
                "Send Email",
                () -> {
                });

        queue.submit(emailTask);

        assertEquals(emailTask, queue.peek());
        assertEquals(1, queue.size());
    }
}
