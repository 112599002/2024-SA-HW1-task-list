package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.port.UseCaseOutput;

public class UncheckUseCase implements UseCase {
    private final int taskId;

    public UncheckUseCase(String id) {
        taskId = Integer.parseInt(id);
    }

    public UseCaseOutput execute() {
        TaskList taskList = TaskList.getTaskList();
        taskList.uncheck(taskId);
        Task task = taskList.getTask(taskId);
        if (task == null) {
            String message = String.format("Could not find a task with an ID of %d.%n", taskId);
            return new UseCaseOutput(message);
        }
        if (!task.isDone()) {
            return new UseCaseOutput("success.");
        }
        String message = String.format("Uncheck task with an ID of %d failedS.%n", taskId);
        return new UseCaseOutput(message);
    }
}
