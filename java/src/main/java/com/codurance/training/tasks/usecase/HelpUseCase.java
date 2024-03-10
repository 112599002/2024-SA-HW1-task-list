package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.usecase.port.UseCaseOutput;

public class HelpUseCase implements UseCase {
    public HelpUseCase() {}

    public UseCaseOutput execute() {
        String message = "Commands:" +
                System.lineSeparator() +
                "  show" +
                System.lineSeparator() +
                "  add project <project name>" +
                System.lineSeparator() +
                "  add task <project name> <task description>" +
                System.lineSeparator() +
                "  check <task ID>" +
                System.lineSeparator() +
                "  uncheck <task ID>" +
                System.lineSeparator() +
                System.lineSeparator();
        return new UseCaseOutput(message);
    }
}
