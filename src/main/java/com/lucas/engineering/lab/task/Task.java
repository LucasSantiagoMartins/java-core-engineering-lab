
package com.lucas.engineering.lab.task;

import java.util.Objects;
import java.util.UUID;

public class Task {

    private final UUID id;
    private final String name;
    private final String description;
    private final ExecutableTask executableTask;

    private TaskStatus status;

    public Task(
            String name,
            String description,
            ExecutableTask executableTask) {
        this(
                UUID.randomUUID(),
                name,
                description,
                executableTask);
    }

    public Task(
            UUID id,
            String name,
            String description,
            ExecutableTask executableTask) {

        Objects.requireNonNull(id);

        this.id = id;
        this.name = name;
        this.description = description;
        this.executableTask = executableTask;
        this.status = TaskStatus.PENDING;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void execute() {
        executableTask.execute();
    }

    public void start() {
        if (status != TaskStatus.PENDING) {
            throw new IllegalStateException("Only pending tasks can be started.");
        }
        status = TaskStatus.RUNNING;
    }

    public void complete() {
        if (status != TaskStatus.RUNNING) {
            throw new IllegalStateException("Only running tasks can be completed.");
        }
        status = TaskStatus.COMPLETED;
    }

    public void fail() {
        if (status != TaskStatus.RUNNING) {
            throw new IllegalStateException("Only running tasks can be failed.");
        }
        status = TaskStatus.FAILED;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (!(object instanceof Task other))
            return false;
        
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
