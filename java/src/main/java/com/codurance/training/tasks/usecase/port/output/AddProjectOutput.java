package com.codurance.training.tasks.usecase.port.output;

public class AddProjectOutput implements UseCaseOutput {
    private String message;
    private int projectId;

    @Override
    public String getOutput() {
        return getMessage();
    }

    public AddProjectOutput() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
