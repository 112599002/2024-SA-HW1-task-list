package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;
import com.codurance.training.tasks.usecase.HelpUseCase;
import com.codurance.training.tasks.usecase.UseCase;
import com.codurance.training.tasks.usecase.port.input.HelpInput;
import com.codurance.training.tasks.usecase.port.output.HelpOutput;
import com.codurance.training.tasks.usecase.port.output.UseCaseOutput;

public class HelpController implements ConsoleController {
    public HelpController() {}

    @Override
    public ConsolePresenter handle(String consoleCommand) {
        UseCase<HelpInput, HelpOutput> useCase = new HelpUseCase();
        UseCaseOutput output = useCase.execute(new HelpInput());
        return new ConsolePresenter(output.getOutput());
    }
}
