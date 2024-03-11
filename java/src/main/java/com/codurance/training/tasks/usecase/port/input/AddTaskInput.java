package com.codurance.training.tasks.usecase.port.input;

public class AddTaskInput implements UseCaseInput{
    private String projectName;
    private String taskDescription;

    public AddTaskInput() {}

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return taskDescription;
    }

    public void setDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
