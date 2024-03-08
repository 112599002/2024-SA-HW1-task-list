package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.TaskList;

public class HelpUseCase implements CommandUseCase {
    public HelpUseCase() {}

    public String execute(TaskList taskList) {
        return "Commands:" +
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
    }
}
