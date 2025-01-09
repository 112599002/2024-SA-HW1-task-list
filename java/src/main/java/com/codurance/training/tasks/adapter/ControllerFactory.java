package com.codurance.training.tasks.adapter;

import com.codurance.training.tasks.adapter.controller.*;
import com.codurance.training.tasks.usecase.*;

public class ControllerFactory {

    public static ConsoleController create(String consoleCommand) {
        String[] tokens = consoleCommand.split(" ");
        String feature = tokens[0];
        switch (feature) {
            case "add":
                // tokens are not enough.
                if (tokens.length < 3) {
                    return new UnknownCommandController(new UnknownCommandUseCase());
                }
                // add which object.
                if (tokens[1].equals("project")) {
                    return new AddProjectController(new AddProjectUseCase());
                }
                else if (tokens[1].equals("task")) {
                    // tokens are not enough.
                    if (tokens.length < 4) {
                        return new UnknownCommandController(new UnknownCommandUseCase());
                    }
                    return new AddTaskController(new AddTaskUseCase());
                }
                else {
                    return new UnknownCommandController(new UnknownCommandUseCase());
                }
            case "check":
                // tokens are not enough.
                if (tokens.length < 2) {
                    return new UnknownCommandController(new UnknownCommandUseCase());
                }
                return new CheckController(new CheckUseCase());
            case "uncheck":
                // tokens are not enough.
                if (tokens.length < 2) {
                    return new UnknownCommandController(new UnknownCommandUseCase());
                }
                return new UncheckController(new UncheckUseCase());
            case "show":
                return new ShowController(new ShowUseCase());
            case "help":
                return new HelpController(new HelpUseCase());
            default:
                return new UnknownCommandController(new UnknownCommandUseCase());
        }
    }
}
