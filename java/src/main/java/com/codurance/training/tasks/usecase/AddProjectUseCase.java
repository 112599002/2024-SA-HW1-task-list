package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.tasklist.TaskList;

public class AddProjectUseCase implements UseCase {
    private String project;
    public AddProjectUseCase(String params) {
        this.project = params;
    }
    public String execute(TaskList taskList) {
        taskList.addProject(project);
        return "ok";
    }
}
