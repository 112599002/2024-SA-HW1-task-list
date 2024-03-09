package com.codurance.training.tasks.adapter.controller.factory;

import com.codurance.training.tasks.usecase.*;

public class CommandUseCaseFactory implements UseCaseFactory{
    public CommandUseCase createUseCase(String commandLine) {
        String[] commandTokens = commandLine.split(" ", 2);
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

    private CommandUseCase addUseCase(String command, String params) {
        String[] commandTokens = params.split(" ", 2);
        String addType = commandTokens[0];
        String remainParams = commandTokens[1];
        if(addType.equals("project")) {
            return new AddProjectUseCase(remainParams);
        } else if (addType.equals("task")) {
            return new AddTaskUseCase(remainParams);
        }
        return new ErrorUseCase(command);
    }
}
