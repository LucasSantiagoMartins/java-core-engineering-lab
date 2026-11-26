package com.lucas.engineering.lab.task;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TaskRegistry {
    private final Set<Task> tasks = new HashSet<>();

    public boolean register(Task task) {
        Objects.requireNonNull(task, "Task cannot be null");
        return tasks.add(task);
    }

    public List<Task> getAll() {
        return List.copyOf(tasks);
    }

    public int size() {
        return tasks.size();
    }
}
