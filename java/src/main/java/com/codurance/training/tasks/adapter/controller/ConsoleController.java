package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;
import com.codurance.training.tasks.usecase.*;
import com.codurance.training.tasks.usecase.port.UseCaseOutput;

public class ConsoleController {

    public ConsoleController() {}

    public ConsolePresenter handle(String consoleCommand) {
        UseCase useCase = createUseCase(consoleCommand);
        UseCaseOutput useCaseOutput = useCase.execute();
        String view = useCaseOutput.getOutput();
        if (view.equals("success.")) {
            return new ConsolePresenter(false, view);
        }
        return new ConsolePresenter(true, view);
    }

    private UseCase createUseCase(String command) {
        String[] commandTokens = command.split(" ", 2);
        String feature = commandTokens[0];
        switch (feature) {
            case "show":
                return new ShowUseCase();
            case "add":
                return addUseCase(feature, commandTokens[1]);
            case "check":
                return new CheckUseCase(commandTokens[1]);
            case "uncheck":
                return new UncheckUseCase(commandTokens[1]);
            case "help":
                return new HelpUseCase();
            default:
                return new ErrorUseCase(feature);
        }
    }

    private UseCase addUseCase(String command, String params) {
        String[] commandTokens = params.split(" ", 2);
        String addType = commandTokens[0];
        String remainParams = commandTokens[1];
        if(addType.equals("project")) {
            return new AddProjectUseCase(remainParams);
        } else if (addType.equals("task")) {
            String[] remaining = remainParams.split(" ", 2);
            String project = remaining[0];
            String description = remaining[1];
            return new AddTaskUseCase(project, description);
        }
        return new ErrorUseCase(command);
    }
}
