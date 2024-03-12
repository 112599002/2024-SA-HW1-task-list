package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;
import com.codurance.training.tasks.usecase.CheckUseCase;
import com.codurance.training.tasks.usecase.UnknownCommandUseCase;
import com.codurance.training.tasks.usecase.UseCase;
import com.codurance.training.tasks.usecase.port.input.CheckInput;
import com.codurance.training.tasks.usecase.port.input.UnknownCommandInput;
import com.codurance.training.tasks.usecase.port.output.CheckOutput;
import com.codurance.training.tasks.usecase.port.output.UnknownCommandOutput;
import com.codurance.training.tasks.usecase.port.output.UseCaseOutput;

public class CheckController implements ConsoleController {
    public CheckController() {}

    @Override
    public ConsolePresenter handle(String consoleCommand) {
        String[] tokens = consoleCommand.split(" ", 2);

        if (tokens.length < 2) {
            UseCase<UnknownCommandInput, UnknownCommandOutput> useCase = new UnknownCommandUseCase();
            UnknownCommandInput input = new UnknownCommandInput();
            input.setCommand(consoleCommand);
            UseCaseOutput output = useCase.execute(input);
            return new ConsolePresenter(output.getOutput());
        }

        UseCase<CheckInput, CheckOutput> useCase = new CheckUseCase();
        String id = tokens[1];
        CheckInput input = new CheckInput();
        input.setTaskId(Integer.parseInt(id));
        UseCaseOutput output = useCase.execute(input);
        return new ConsolePresenter(output.getOutput());
    }
}
