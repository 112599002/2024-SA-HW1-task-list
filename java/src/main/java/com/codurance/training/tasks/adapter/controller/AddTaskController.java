package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;
import com.codurance.training.tasks.usecase.AddTaskUseCase;
import com.codurance.training.tasks.usecase.UnknownCommandUseCase;
import com.codurance.training.tasks.usecase.UseCase;
import com.codurance.training.tasks.usecase.port.input.AddTaskInput;
import com.codurance.training.tasks.usecase.port.input.UnknownCommandInput;
import com.codurance.training.tasks.usecase.port.output.AddTaskOutput;
import com.codurance.training.tasks.usecase.port.output.UnknownCommandOutput;
import com.codurance.training.tasks.usecase.port.output.UseCaseOutput;

public class AddTaskController implements ConsoleController {
    private final UseCase<AddTaskInput, AddTaskOutput> addTaskUseCase;

    public AddTaskController(UseCase<AddTaskInput, AddTaskOutput> addTaskUseCase) {
        this.addTaskUseCase = addTaskUseCase;
    }

    @Override
    public ConsolePresenter handle(String consoleCommand) {
        String[] tokens = consoleCommand.split(" ", 4);
        String project = tokens[2];
        String description = tokens[3];
        AddTaskInput input = new AddTaskInput();
        input.setProjectName(project);
        input.setDescription(description);
        UseCaseOutput output = addTaskUseCase.execute(input);
        return new ConsolePresenter(output.getOutput());
    }
}
