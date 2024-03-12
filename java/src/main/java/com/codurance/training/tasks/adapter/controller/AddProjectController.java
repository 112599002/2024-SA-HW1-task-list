package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;
import com.codurance.training.tasks.usecase.AddProjectUseCase;
import com.codurance.training.tasks.usecase.UnknownCommandUseCase;
import com.codurance.training.tasks.usecase.UseCase;
import com.codurance.training.tasks.usecase.port.input.AddProjectInput;
import com.codurance.training.tasks.usecase.port.input.UnknownCommandInput;
import com.codurance.training.tasks.usecase.port.output.UseCaseOutput;

public class AddProjectController implements ConsoleController {
    public AddProjectController() {}

    @Override
    public ConsolePresenter handle(String consoleCommand) {
        String[] tokens = consoleCommand.split(" ", 3);

        if (tokens.length < 3) {
            UseCase useCase = new UnknownCommandUseCase();
            UnknownCommandInput input = new UnknownCommandInput();
            input.setCommand(consoleCommand);
            UseCaseOutput output = useCase.execute(input);
            return new ConsolePresenter(output.getOutput());
        }

        UseCase useCase = new AddProjectUseCase();
        String project = tokens[2];
        AddProjectInput input = new AddProjectInput();
        input.setProjectName(project);
        UseCaseOutput output = useCase.execute(input);
        return new ConsolePresenter(output.getOutput());
    }
}
