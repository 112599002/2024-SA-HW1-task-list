package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Project;
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
        Project project = taskList.getProject(projectName);
        if (project == null) {
            String message = String.format("Could not find a project with the name \"%s\".%n", projectName);
            return new UseCaseOutput(message);
        }
        taskList.addTask(projectName, description);
        return new UseCaseOutput("success.");
    }
}
