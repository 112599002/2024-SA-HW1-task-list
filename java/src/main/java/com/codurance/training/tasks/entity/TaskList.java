package com.codurance.training.tasks.entity;

import java.util.*;

public class TaskList {
    private List<Project> projects = new ArrayList<>();
    private int lastProjectId = 0;
    private long lastTaskId = 0;

    private static TaskList taskList = null;

    private TaskList() {}

    public Map<String, List<Task>> getAllTasks() {
        Map<String, List<Task>> tasks = new LinkedHashMap<>();
        for (Project project : projects) {
            tasks.put(project.name(), project.tasks());
        }
        return tasks;
    }

    public void addProject(String name) {
        int projectId = newProjectId();
        projects.add(new Project(projectId, name));
    }

    public Project getProject(String projectName) {
        for (Project project : projects) {
            if (project.name().equals(projectName)) {
                return project;
            }
        }
        return null;
    }

    public long addTask(String projectName, String description) {
        Project project = getProject(projectName);
        if (project == null) {
            return -1;
        }
        long newId = newTaskId();
        project.addTask(newId, description);
        return newId;
    }

    public Task getTask(long taskId) {
        for (Project project : projects) {
            Task task = project.getTask(taskId);
            if (task != null) {
                return task;
            }
        }
        return null;
    }

    public void check(int taskId) {
        Task task = getTask(taskId);
        if(task != null) {
            task.setDone(true);
        }
    }

    public void uncheck(int taskId) {
        Task task = getTask(taskId);
        if(task != null) {
            task.setDone(false);
        }    }

    private int newProjectId() {
        return ++lastProjectId;
    }

    private long newTaskId() {
        return ++lastTaskId;
    }

    public static TaskList getTaskList() {
        if (taskList == null) {
            taskList = new TaskList();
        }
        return taskList;
    }

}
