package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.port.UseCaseOutput;

public class AddProjectUseCase implements UseCase {
    private final String projectName;

    public AddProjectUseCase(String project) {
        this.projectName = project;
    }

    public UseCaseOutput execute() {
        TaskList taskList = TaskList.getTaskList();
        taskList.addProject(projectName);
        if (taskList.getProject(projectName) != null) {
            return new UseCaseOutput("success.");
        }
        String message = String.format("Add project \"%s\" failed.%n", projectName);
        return new UseCaseOutput(message);
    }
}
