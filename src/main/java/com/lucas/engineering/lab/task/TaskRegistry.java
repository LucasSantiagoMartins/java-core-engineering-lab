package com.lucas.engineering.lab.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class TaskRegistry {
    private final Map<UUID,Task> tasks = new HashMap<>();

    public boolean register(Task task) {
        Objects.requireNonNull(task, "Task cannot be null");        
        
        return tasks.putIfAbsent(task.getId(), task) == null;
    }
    
    public List<Task> getAll() {
        return List.copyOf(tasks.values());
    }
    
    public Optional<Task> findById(UUID id){
        Objects.requireNonNull(id, "TaskID cannot be null");
        return Optional.ofNullable(tasks.get(id));
    }
 
    public int size() {
        return tasks.size();
    }
}
