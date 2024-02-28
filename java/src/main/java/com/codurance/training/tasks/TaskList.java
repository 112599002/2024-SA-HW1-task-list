package com.codurance.training.tasks;

import java.util.*;

/*
由於在看原本的 TaskList code 時需要兩種思不斷轉換的思考和看 code
1. command line 對應的 I/O 動作
2. TaskList 物件的屬性、方法
所以有了拆分單純 TaskList 物件和 TaskListApp 的想法。
 */

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
