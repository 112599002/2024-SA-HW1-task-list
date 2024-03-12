package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;
import com.codurance.training.tasks.usecase.UnknownCommandUseCase;
import com.codurance.training.tasks.usecase.UseCase;
import com.codurance.training.tasks.usecase.port.input.UnknownCommandInput;
import com.codurance.training.tasks.usecase.port.output.UnknownCommandOutput;
import com.codurance.training.tasks.usecase.port.output.UseCaseOutput;

public class UnknownCommandController implements ConsoleController {
    public UnknownCommandController() {}

    @Override
    public ConsolePresenter handle(String consoleCommand) {
        UseCase<UnknownCommandInput, UnknownCommandOutput> useCase = new UnknownCommandUseCase();
        UnknownCommandInput input = new UnknownCommandInput();
        input.setCommand(consoleCommand);
        UseCaseOutput output = useCase.execute(input);
        return new ConsolePresenter(output.getOutput());
    }
}
