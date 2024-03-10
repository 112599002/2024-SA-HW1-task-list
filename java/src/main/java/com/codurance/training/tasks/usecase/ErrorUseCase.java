package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.usecase.port.UseCaseOutput;

public class ErrorUseCase implements UseCase {
    private final String error;
    public ErrorUseCase(String command) {
        this.error = command;
    }

    public UseCaseOutput execute() {
        String message = String.format("I don't know what the command \"%s\" is.%n", error);
        return new UseCaseOutput(message);
    }
}
