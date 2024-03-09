package com.codurance.training.tasks.entity;

import java.util.*;

public class TaskList {
//    private List<Project> projects = new ArrayList<>();
    private Map<Integer, Project> projects = new HashMap<>(); // <user added order, Project>
    private int lastProjectId = 0;
    private long lastTaskId = 0;

    public TaskList() {}

    public Map<String, List<Task>> getAllTasks() {
        Map<String, List<Task>> tasks = new HashMap<>();
        for (Map.Entry<Integer, Project> projectSet : projects.entrySet()) {
            Project project = projectSet.getValue();
            tasks.put(project.name(), project.tasks());
        }
        return Collections.unmodifiableMap(tasks);
    }

    public void addProject(String name) {
        int projectId = newProjectId();
        projects.put(projectId, new Project(projectId, name));
    }

    public Project getProject(String projectName) {
        for (Map.Entry<Integer, Project> projectSet : projects.entrySet()) {
            Project project = projectSet.getValue();
            if (project.name().equals(projectName)) {
                return project;
            }
        }
        return null;
    }

    public void addTask(String projectName, String description) {
        Project project = getProject(projectName);
        if (project == null) {
            return;
        }
        long newId = newTaskId();
        project.addTask(newId, description);
    }

    public Task getTask(int taskId) {
        for (Map.Entry<Integer, Project> projectSet : projects.entrySet()) {
            Project project = projectSet.getValue();
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
}
