package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.TaskList;

public class AddProjectUseCase implements CommandUseCase {
    private final String project;
    public AddProjectUseCase(String params) {
        this.project = params;
    }
    public String execute(TaskList taskList) {
        taskList.addProject(project);
        return "ok";
    }
}
