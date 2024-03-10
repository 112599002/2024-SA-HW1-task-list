package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Project;
import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.port.UseCaseOutput;

public class AddTaskUseCase implements UseCase {
    private final String projectName;
    private final String description;

    public AddTaskUseCase(String project, String description) {
        this.projectName = project;
        this.description = description;
    }

    public UseCaseOutput execute() {
        TaskList taskList = TaskList.getTaskList();
        long newTaskId = taskList.addTask(projectName, description);
        if (newTaskId < 0) {
            String message = String.format("Could not find a project with the name \"%s\".%n", projectName);
            return new UseCaseOutput(message);
        }
        Task task = taskList.getTask(newTaskId);
        if (task.getId() == newTaskId) {
            return new UseCaseOutput("success.");
        }
        String message = String.format("Add task \"%s\" failed.%n", description);
        return new UseCaseOutput(message);
    }
}
