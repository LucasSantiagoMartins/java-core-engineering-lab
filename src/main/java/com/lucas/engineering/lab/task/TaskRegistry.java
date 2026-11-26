package com.lucas.engineering.lab.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskRegistry {
    private final List<Task> tasks = new ArrayList<>();

    public void register(Task task) {
        Objects.requireNonNull(task, "Task cannot be null");
        tasks.add(task);
    }

    public List<Task> getAll() {
        return List.copyOf(tasks);
    }

    public int size() {
        return tasks.size();
    }
}
