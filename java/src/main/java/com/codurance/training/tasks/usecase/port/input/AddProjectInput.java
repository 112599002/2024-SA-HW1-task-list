package com.codurance.training.tasks.usecase.port.input;

public class AddProjectInput implements UseCaseInput{
    private String projectName;

    public AddProjectInput() {}

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
