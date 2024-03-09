package com.codurance.training.tasks.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project {
    private final String name;
    private final List<Task> tasks;

    public Project(String projectName) {
        this.name = projectName;
        this.tasks = new ArrayList<>();
    }

    public String name() {
        return this.name;
    }

    public List<Task> tasks() {
        return Collections.unmodifiableList(tasks);
    }

    public void addTask(long id, String description) {
        tasks.add(new Task(id, description, false));
    }

    public Task getTask(long id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
