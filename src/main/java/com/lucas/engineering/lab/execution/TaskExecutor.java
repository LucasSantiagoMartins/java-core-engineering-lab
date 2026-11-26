package com.lucas.engineering.lab.execution;

import java.util.Objects;

import com.lucas.engineering.lab.task.Task;

public class TaskExecutor {

    public ExecutionResult execute(Task task) {
        Objects.requireNonNull(task, "Task cannot be null");
        task.start();
        try {
            task.execute();
            task.complete();
            return new ExecutionResult(task.getName(), task.getStatus(), null);
        } catch (RuntimeException exception) {
            task.fail();
            return new ExecutionResult(task.getName(), task.getStatus(), exception.getMessage());
        }
    }
}
