package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.TaskList;

public class AddProjectUseCase implements CommandUseCase {
    private final String projectName;
    public AddProjectUseCase(String project) {
        this.projectName = project;
    }
    public String execute() {
        TaskList taskList = TaskList.getTaskList();
        taskList.addProject(projectName);
        return "ok";
    }
}
