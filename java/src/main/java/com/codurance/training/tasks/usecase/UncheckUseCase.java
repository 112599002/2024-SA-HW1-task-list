package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;

public class UncheckUseCase implements CommandUseCase {
    private final int taskId;
    public UncheckUseCase(String params) {
        taskId = Integer.parseInt(params);
    }

    public String execute(TaskList taskList) {
        Task task = taskList.getTask(taskId);
        if (task == null) {
            return String.format("Could not find a task with an ID of %d.%n", taskId);
        }
        taskList.uncheck(taskId);
        return "ok";
    }
}
