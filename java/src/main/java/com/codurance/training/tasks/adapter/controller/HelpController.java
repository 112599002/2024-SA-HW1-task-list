package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;
import com.codurance.training.tasks.usecase.HelpUseCase;
import com.codurance.training.tasks.usecase.UseCase;
import com.codurance.training.tasks.usecase.port.input.HelpInput;
import com.codurance.training.tasks.usecase.port.input.UnknownCommandInput;
import com.codurance.training.tasks.usecase.port.output.HelpOutput;
import com.codurance.training.tasks.usecase.port.output.UnknownCommandOutput;
import com.codurance.training.tasks.usecase.port.output.UseCaseOutput;

public class HelpController implements ConsoleController {
    private final UseCase<HelpInput, HelpOutput> helpUseCase;

    public HelpController(UseCase<HelpInput, HelpOutput> helpUseCase) {
        this.helpUseCase = helpUseCase;
    }

    @Override
    public ConsolePresenter handle(String consoleCommand) {
        UseCaseOutput output = helpUseCase.execute(new HelpInput());
        return new ConsolePresenter(output.getOutput());
    }
}
