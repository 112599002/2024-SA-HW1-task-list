package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.tasklist.TaskList;

public class ErrorUseCase implements UseCase {
    private String error;
    public ErrorUseCase(String command) {
        this.error = command;
    }
    public String execute(TaskList taskList) {
        return String.format("I don't know what the command \"%s\" is.%n", error);
    }
}
