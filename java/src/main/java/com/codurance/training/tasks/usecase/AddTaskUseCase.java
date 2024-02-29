package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.tasklist.Task;
import com.codurance.training.tasks.tasklist.TaskList;

import java.util.List;

public class AddTaskUseCase implements CommandUseCase {
    private final String project;
    private final String description;
    public AddTaskUseCase(String params) {
        String[] commandTokens = params.split(" ", 2);
        this.project = commandTokens[0];
        this.description = commandTokens[1];
    }
    public String execute(TaskList taskList) {
        List<Task> projectTasks = taskList.getProject(project);
        if (projectTasks == null) {
            return String.format("Could not find a project with the name \"%s\".%n", project);
        }
        taskList.addTask(project, description);
        return "ok";
    }
}
