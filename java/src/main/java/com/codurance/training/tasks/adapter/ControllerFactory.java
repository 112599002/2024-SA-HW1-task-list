package com.codurance.training.tasks.adapter;

import com.codurance.training.tasks.adapter.controller.*;
import com.codurance.training.tasks.usecase.*;

public class ControllerFactory {
    public ControllerFactory() {}

    public static ConsoleController create(String consoleCommand) {
        String[] tokens = consoleCommand.split(" ", 2);
        String feature = tokens[0];
        switch (feature) {
            case "add":
                return addController(consoleCommand);
            case "check":
                return new CheckController(new UnknownCommandUseCase(), new CheckUseCase());
            case "uncheck":
                return new UncheckController(new UnknownCommandUseCase(), new UncheckUseCase());
            case "show":
                return new ShowController(new ShowUseCase());
            case "help":
                return new HelpController(new HelpUseCase());
            default:
                return new UnknownCommandController(new UnknownCommandUseCase());
        }
    }

    private static ConsoleController addController(String consoleCommand) {
        String[] tokens = consoleCommand.split(" ", 3);

        if (tokens.length < 2) {
            return new UnknownCommandController(new UnknownCommandUseCase());
        }

        if (tokens[1].equals("project")) {
            return new AddProjectController(new UnknownCommandUseCase(), new AddProjectUseCase());
        }
        else if (tokens[1].equals("task")) {
            return new AddTaskController(new UnknownCommandUseCase(), new AddTaskUseCase());
        }
        else {
            return new UnknownCommandController(new UnknownCommandUseCase());
        }
    }
}
