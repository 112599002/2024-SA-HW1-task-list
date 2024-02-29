package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.tasklist.Task;
import com.codurance.training.tasks.tasklist.TaskList;

import java.util.List;
import java.util.Map;

public class ShowUseCase implements UseCase {
    public ShowUseCase() {}

    public String execute(TaskList taskList) {
        Map<String, List<Task>> tasks = taskList.getAllTasks();
        if(tasks.isEmpty()) {
            return "ok";
        }
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            builder.append(project.getKey());
            builder.append(System.lineSeparator());
            for (Task task : project.getValue()) {
                String info = taskInfo(task.isDone(), task.getId(), task.getDescription());
                builder.append(info);
                builder.append(System.lineSeparator());
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    private String taskInfo(boolean isDone, long id, String description) {
        return String.format("    [%c] %d: %s", (isDone ? 'x' : ' '), id, description);
    }
}
