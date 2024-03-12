package com.codurance.training.tasks.usecase.port.input;

public class UncheckInput implements UseCaseInput {
    private int taskId;

    public UncheckInput() {}

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
