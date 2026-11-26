package com.lucas.engineering.lab.execution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.lucas.engineering.lab.task.Task;
import com.lucas.engineering.lab.task.TaskStatus;

class TaskExecutorTest {
    TaskExecutor executor = new TaskExecutor();

    @Test
    void shouldCompleteTaskSuccessfully() {

        Task emailTask = new Task(
                "Send welcome email",
                "Send Email",
                () -> {});

        ExecutionResult emailResult = executor.execute(emailTask);

        assertEquals(emailResult.status(), TaskStatus.COMPLETED);
        assertTrue(emailResult.isSuccessful());
    }

    @Test
    void shouldMarkAsFailedWhenExecutionThrowsException() {

        Task paymentTask = new Task(
                "Process payment",
                "Process customer payment",
                () -> {
                    throw new RuntimeException("Payment gateway unavailable");
                });

        ExecutionResult paymentResult = executor.execute(paymentTask);

        assertEquals(paymentResult.status(), TaskStatus.FAILED);
        assertFalse(paymentResult.isSuccessful());
        assertEquals(paymentResult.failureMessage(), "Payment gateway unavailable");
    }

    @Test
    void shouldNotExecuteCompletedTask() {
        
        Task reportTask = new Task(
                "Generate report",
                "Generate monthly report",
                () -> {}
        );

        executor.execute(reportTask);

        assertThrows(IllegalStateException.class, () -> executor.execute(reportTask));
    }
}
