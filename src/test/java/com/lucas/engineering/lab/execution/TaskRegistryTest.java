package com.lucas.engineering.lab.execution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.lucas.engineering.lab.task.Task;
import com.lucas.engineering.lab.task.TaskRegistry;

class TaskRegistryTest {
    @Test
    void shouldRegisterTasks() {
        TaskRegistry registry = new TaskRegistry();

        Task emailTask = new Task(
                "Send welcome email",
                "Send Email",
                () -> {
                });

        registry.register(emailTask);

        assertEquals(1, registry.size());
    }

    @Test
    void shouldReturnUnmodifiableList() {

        TaskRegistry registry = new TaskRegistry();

        Task reportTask = new Task(
                "Generate report",
                "Generate monthly report",
                () -> {
                });

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

    @Test
    void shoudRejectDuplicateTasks() {
        TaskRegistry registry = new TaskRegistry();

        Task reportTask = new Task(
                "Generate report",
                "Generate monthly report",
                () -> {
                });

        registry.register(reportTask);

        assertFalse(registry.register(reportTask));
        assertEquals(1, registry.size());
    }

    @Test
    void shouldAcceptDifferentTaskInstances() {
        TaskRegistry registry = new TaskRegistry();

        Task firstTask = new Task(
                "Send Email",
                "Send welcome email",
                () -> {
                });

        Task secondTask = new Task(
                "Send Email",
                "Send welcome email",
                () -> {
                });

        registry.register(firstTask);
        registry.register(secondTask);

        assertEquals(2, registry.size());
    }

    @Test
    void shouldConsiderTaskWithSameIdAsEqual() {
        UUID taskId = UUID.randomUUID();

        Task firstTask = new Task(
                taskId,
                "Send Email",
                "Send welcome email",
                () -> {
                });

        Task secondTask = new Task(
                taskId,
                "Send Email",
                "Send welcome email",
                () -> {
                });

        assertTrue(firstTask.equals(secondTask));
        assertEquals(firstTask.hashCode(), secondTask.hashCode());
        assertEquals(firstTask, secondTask);
    }

    @Test
    void shouldConsiderTaskWithDifferentIdsAsDifferent() {
        Task firstTask = new Task(
                "Send Email",
                "Send welcome email",
                () -> {
                });

        Task secondTask = new Task(
                "Send Email",
                "Send welcome email",
                () -> {
                });

        assertFalse(firstTask.equals(secondTask));
        assertNotEquals(firstTask, secondTask);
    }

    @Test
    void shouldFindTaskById() {
        TaskRegistry registry = new TaskRegistry();
        UUID taskId = UUID.randomUUID();
        UUID unkUuid = UUID.randomUUID();   

        Task emailTask = new Task(
                taskId,
                "Send Email",
                "Send welcome email",
                () -> {}
        );
        registry.register(emailTask);

        Optional<Task> foundTask = registry.findById(taskId);
        Optional<Task> unknownTask = registry.findById(unkUuid);

        assertTrue(foundTask.isPresent());
        assertEquals(emailTask, foundTask.get());
        assertFalse(unknownTask.isPresent());
    }

    @Test
    void shouldIgnoreDuplicateTasks() {
        TaskRegistry registry = new TaskRegistry();
        UUID taskId = UUID.randomUUID();

        Task firstTask = new Task(
                taskId,
                "Send Email",
                "Send welcome email",
                () -> {}
        );

         Task secondTask = new Task(
                taskId,
                "Send Email",
                "Send welcome email",
                () -> {}
        );

        registry.register(firstTask);
        registry.register(secondTask);

        assertEquals(1, registry.size());

    }
}
