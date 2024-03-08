package com.codurance.training.tasks.entity;

import java.util.*;

public class TaskList {
    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private final List<Project> projects = new ArrayList<>();
    private long lastTaskId = 0;

    public TaskList() {}

    public Map<String, List<Task>> getAllTasks() {
        return Collections.unmodifiableMap(tasks);
    }

    public void addProject(String name) {
        projects.add(new Project(name));
    }

    public Project getProject(String projectName) {
        for (Project projcet : projects) {
            if (projcet.name().equals(projectName)) {
                return projcet;
            }
        }
        return null;
    }

    public void addTask(String project, String description) {
        if(tasks.containsKey(project)) {
            long newId = newTaskId();
            tasks.get(project).add(new Task(newId, description, false));
        }
    }

    public Task getTask(int taskId) {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if(task.getId() == taskId) {
                    return task;
                }
            }
        }
        return null;
    }

    public void check(Task task) {
        task.setDone(true);
    }

    public void uncheck(Task task) {
        task.setDone(false);
    }

    private long newTaskId() {
        return ++lastTaskId;
    }

}
