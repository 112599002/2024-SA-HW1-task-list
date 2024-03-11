package com.codurance.training.tasks.usecase.port.output;

public class AddTaskOutput implements UseCaseOutput{
    private String message;
    private long taskId;

    public AddTaskOutput() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long projectId) {
        this.taskId = projectId;
    }
}
