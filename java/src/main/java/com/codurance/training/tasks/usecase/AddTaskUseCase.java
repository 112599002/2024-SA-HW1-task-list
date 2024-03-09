package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Project;
import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;

import java.util.List;

public class AddTaskUseCase implements CommandUseCase {
    private final String projectName;
    private final String description;
    public AddTaskUseCase(String project, String description) {
        this.projectName = project;
        this.description = description;
    }
    public String execute() {
        TaskList taskList = TaskList.getTaskList();
        Project project = taskList.getProject(projectName);
        if (project == null) {
            return String.format("Could not find a project with the name \"%s\".%n", projectName);
        }
        taskList.addTask(projectName, description);
        return "ok";
    }
}
