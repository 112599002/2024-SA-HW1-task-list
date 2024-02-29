package com.codurance.training.tasks.tasklist;

import java.util.*;

public class TaskList {
    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();

    private long lastTaskId = 0;

    public TaskList() {}

    public Map<String, List<Task>> getAllTasks() {
        return Collections.unmodifiableMap(tasks);
    }

    public void addProject(String name) {
        tasks.put(name, new ArrayList<Task>());
    }

    public List<Task> getProject(String project) {
        if(!tasks.containsKey(project)) {
            return null;
        }
        return Collections.unmodifiableList(tasks.get(project));
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
