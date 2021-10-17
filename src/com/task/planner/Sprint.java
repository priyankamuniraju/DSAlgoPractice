package com.task.planner;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Sprint {

    private final String id;
    private String name;
    private Map<String, Task> tasks;

    public Sprint(Map<String, Task> tasks, String name) {
        this.tasks = tasks;
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public Sprint(String name) {
        this.name = name;
        this.tasks = new HashMap<>();
        this.id = UUID.randomUUID().toString();
    }

    public Map<String, Task> getTasks() {
        return tasks;
    }

    public void setTasks(Map<String, Task> tasks) {
        this.tasks = tasks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sprint sprint = (Sprint) o;
        return Objects.equals(tasks, sprint.tasks) && Objects.equals(id, sprint.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tasks, id);
    }
}
