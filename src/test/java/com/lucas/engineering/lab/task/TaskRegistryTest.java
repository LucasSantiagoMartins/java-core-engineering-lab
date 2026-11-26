package com.lucas.engineering.lab.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

class TaskRegistryTest {
    @Test
    void shouldRegisterTasks() {
        TaskRegistry registry = new TaskRegistry();

        Task emailTask = new Task(
                "Send welcome email",
                "Send Email",
                () -> System.out.println("Sending email..."));

        registry.register(emailTask);

        assertEquals(1, registry.size());
    }

    @Test
    void shouldReturnUnmodifiableList() {

        TaskRegistry registry = new TaskRegistry();

        Task reportTask = new Task(
                "Generate report",
                "Generate monthly report",
                () -> System.out.println("Generating report..."));

        registry.register(reportTask);

        List<Task> tasks = registry.getAll();

        assertThrows(UnsupportedOperationException.class, () -> tasks.clear());
        assertEquals(1, tasks.size());
    }

    @Test
    void shouldRejectNullTasks() {

        TaskRegistry registry = new TaskRegistry();

        assertThrows(NullPointerException.class, () -> registry.register(null));
    }
}
