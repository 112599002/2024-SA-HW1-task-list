package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;

public class UncheckUseCase implements CommandUseCase {
    private final int taskId;
    public UncheckUseCase(String id) {
        taskId = Integer.parseInt(id);
    }

    public String execute() {
        TaskList taskList = TaskList.getTaskList();
        Task task = taskList.getTask(taskId);
        if (task == null) {
            return String.format("Could not find a task with an ID of %d.%n", taskId);
        }
        taskList.uncheck(taskId);
        return "ok";
    }
}
