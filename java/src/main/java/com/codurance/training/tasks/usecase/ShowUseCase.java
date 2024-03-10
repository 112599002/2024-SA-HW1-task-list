package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.port.UseCaseOutput;

import java.util.List;
import java.util.Map;

public class ShowUseCase implements UseCase {
    public ShowUseCase() {}

    public UseCaseOutput execute() {
        TaskList taskList = TaskList.getTaskList();
        Map<String, List<Task>> tasks = taskList.getAllTasks();
        if(tasks.isEmpty()) {
            return new UseCaseOutput("success.");
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
        String message = builder.toString();
        return new UseCaseOutput(message);
    }

    private String taskInfo(boolean isDone, long id, String description) {
        return String.format("    [%c] %d: %s", (isDone ? 'x' : ' '), id, description);
    }
}
