package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;
import com.codurance.training.tasks.usecase.UncheckUseCase;
import com.codurance.training.tasks.usecase.UnknownCommandUseCase;
import com.codurance.training.tasks.usecase.UseCase;
import com.codurance.training.tasks.usecase.port.input.UncheckInput;
import com.codurance.training.tasks.usecase.port.input.UnknownCommandInput;
import com.codurance.training.tasks.usecase.port.output.UncheckOutput;
import com.codurance.training.tasks.usecase.port.output.UnknownCommandOutput;
import com.codurance.training.tasks.usecase.port.output.UseCaseOutput;

public class UncheckController implements ConsoleController {
    private final UseCase<UncheckInput, UncheckOutput> uncheckUseCase;

    public UncheckController(UseCase<UncheckInput, UncheckOutput> uncheckUseCase) {
        this.uncheckUseCase = uncheckUseCase;
    }

    @Override
    public ConsolePresenter handle(String consoleCommand) {
        String[] tokens = consoleCommand.split(" ", 2);
        String id = tokens[1];
        UncheckInput input = new UncheckInput();
        input.setTaskId(Integer.parseInt(id));
        UseCaseOutput output = uncheckUseCase.execute(input);
        return new ConsolePresenter(output.getOutput());
    }
}
