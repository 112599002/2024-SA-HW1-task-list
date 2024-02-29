package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.tasklist.TaskList;

public class HelpUseCase implements UseCase {
    public HelpUseCase() {}

    public String execute(TaskList taskList) {
        StringBuilder builder = new StringBuilder();
        builder.append("Commands:");
        builder.append(System.lineSeparator());
        builder.append("  show");
        builder.append(System.lineSeparator());
        builder.append("  add project <project name>");
        builder.append(System.lineSeparator());
        builder.append("  add task <project name> <task description>");
        builder.append(System.lineSeparator());
        builder.append("  check <task ID>");
        builder.append(System.lineSeparator());
        builder.append("  uncheck <task ID>");
        builder.append(System.lineSeparator());
        builder.append(System.lineSeparator());
        return builder.toString();
    }
}
