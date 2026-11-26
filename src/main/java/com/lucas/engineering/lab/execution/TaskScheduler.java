package com.lucas.engineering.lab.execution;

import java.util.Objects;
import java.util.Optional;

import com.lucas.engineering.lab.task.Task;
import com.lucas.engineering.lab.task.TaskRegistry;

public class TaskScheduler {
    private final TaskRegistry registry;
    private final TaskQueue queue;
    private final TaskExecutor executor;

    public TaskScheduler(TaskRegistry registry, TaskQueue queue, TaskExecutor executor) {
        this.registry = Objects.requireNonNull(registry);
        this.queue = Objects.requireNonNull(queue);
        this.executor = Objects.requireNonNull(executor);
    }

    public boolean submit(Task task) {
        Objects.requireNonNull(task, "Task cannot be null");

        boolean registered = registry.register(task);

        if (!registered)
            return false;

        queue.submit(task);

        return true;
    }

    public Optional<ExecutionResult> executeNext() {

        Task task = queue.poll();

        if (task == null) {
            return Optional.empty();
        }

        return Optional.of(executor.execute(task));
    }

    public int registeredTasksCount() {
        return registry.size();
    }

    public int pendingTasksCount() {
        return queue.size();
    }
}
