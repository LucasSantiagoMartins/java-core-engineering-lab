package com.lucas.engineering.lab.execution;

import com.lucas.engineering.lab.task.TaskStatus;

public record ExecutionResult(
    String taskName,
    TaskStatus status,
    String failureMessage
){

    public boolean isSuccessful() {
        return status == TaskStatus.COMPLETED;
    }
}
