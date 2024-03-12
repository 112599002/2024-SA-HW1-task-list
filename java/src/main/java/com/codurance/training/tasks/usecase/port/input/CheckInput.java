package com.codurance.training.tasks.usecase.port.input;

public class CheckInput implements UseCaseInput {
    private int taskId;

    public CheckInput() {}

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
