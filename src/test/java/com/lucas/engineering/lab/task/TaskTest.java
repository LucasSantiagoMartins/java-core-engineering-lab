package com.lucas.engineering.lab.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    void shoudStartWithPendingStatus() {

        Task emailTask = new Task(
            "Send welcome email",
            "Send Email",
            () -> System.out.println("Sending email...")
        );

        TaskStatus status = emailTask.getStatus();

        assertEquals(status, TaskStatus.PENDING);
    }
}
