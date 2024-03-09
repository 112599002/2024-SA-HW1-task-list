package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Project;
import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;

import java.util.List;

public class AddTaskUseCase implements CommandUseCase {
    private final String projectName;
    private final String description;
    public AddTaskUseCase(String params) {
        String[] commandTokens = params.split(" ", 2);
        this.projectName = commandTokens[0];
        this.description = commandTokens[1];
    }
    public String execute(TaskList taskList) {
        Project project = taskList.getProject(projectName);
        if (project == null) {
            return String.format("Could not find a project with the name \"%s\".%n", projectName);
        }
        taskList.addTask(projectName, description);
        return "ok";
    }
}
