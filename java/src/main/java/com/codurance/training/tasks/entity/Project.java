package com.codurance.training.tasks.entity;

import java.util.Collections;
import java.util.List;

public class Project {
    private final String name;
    private final List<Task> tasks;

    public Project(String projectName) {
        this.name = projectName;
    }

    public String name() {
        return this.name;
    }

    public List<Task> tasks() {
        return Collections.unmodifiableList(tasks);
    }
}
