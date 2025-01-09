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
    private final UseCase<CheckInput, CheckOutput> checkUseCase;

    public CheckController(UseCase<CheckInput, CheckOutput> checkUseCase) {
        this.checkUseCase = checkUseCase;
    }

    @Override
    public ConsolePresenter handle(String consoleCommand) {
        String[] tokens = consoleCommand.split(" ", 2);
        String id = tokens[1];
        CheckInput input = new CheckInput();
        input.setTaskId(Integer.parseInt(id));
        UseCaseOutput output = checkUseCase.execute(input);
        return new ConsolePresenter(output.getOutput());
    }
}
