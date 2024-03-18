package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;
import com.codurance.training.tasks.usecase.AddProjectUseCase;
import com.codurance.training.tasks.usecase.UnknownCommandUseCase;
import com.codurance.training.tasks.usecase.UseCase;
import com.codurance.training.tasks.usecase.port.input.AddProjectInput;
import com.codurance.training.tasks.usecase.port.input.UnknownCommandInput;
import com.codurance.training.tasks.usecase.port.output.AddProjectOutput;
import com.codurance.training.tasks.usecase.port.output.UnknownCommandOutput;
import com.codurance.training.tasks.usecase.port.output.UseCaseOutput;

public class AddProjectController implements ConsoleController {
    private final UseCase<UnknownCommandInput, UnknownCommandOutput> unknowUseCase;
    private final UseCase<AddProjectInput, AddProjectOutput> addProjectUseCase;

    public AddProjectController(UseCase<UnknownCommandInput, UnknownCommandOutput> unknowUseCase,
                                UseCase<AddProjectInput, AddProjectOutput> addProjectUseCase) {
        this.unknowUseCase = unknowUseCase;
        this.addProjectUseCase = addProjectUseCase;
    }

    @Override
    public ConsolePresenter handle(String consoleCommand) {
        String[] tokens = consoleCommand.split(" ", 3);

        if (tokens.length < 3) {
            UnknownCommandInput input = new UnknownCommandInput();
            input.setCommand(consoleCommand);
            UseCaseOutput output = unknowUseCase.execute(input);
            return new ConsolePresenter(output.getOutput());
        }

        String project = tokens[2];
        AddProjectInput input = new AddProjectInput();
        input.setProjectName(project);
        UseCaseOutput output = addProjectUseCase.execute(input);
        return new ConsolePresenter(output.getOutput());
    }
}
