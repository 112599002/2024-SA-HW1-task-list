package com.codurance.training.tasks.adapter;

import com.codurance.training.tasks.adapter.controller.*;

public class ControllerFactory {
    public ControllerFactory() {}

    public static ConsoleController create(String consoleCommand) {
        String[] tokens = consoleCommand.split(" ", 2);
        String feature = tokens[0];
        switch (feature) {
            case "add":
                return addController(consoleCommand);
            case "check":
                return new CheckController();
            case "uncheck":
                return new UncheckController();
            case "show":
                return new ShowController();
            case "help":
                return new HelpController();
            default:
                return new UnknownCommandController();
        }
    }

    private static ConsoleController addController(String consoleCommand) {
        String[] tokens = consoleCommand.split(" ", 3);

        if (tokens.length < 2) {
            return new UnknownCommandController();
        }

        if (tokens[1].equals("project")) {
            return new AddProjectController();
        }
        else if (tokens[1].equals("task")) {
            return new AddTaskController();
        }
        else {
            return new UnknownCommandController();
        }
    }
}
