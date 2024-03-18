package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;
import com.codurance.training.tasks.usecase.ShowUseCase;
import com.codurance.training.tasks.usecase.UseCase;
import com.codurance.training.tasks.usecase.port.input.ShowInput;
import com.codurance.training.tasks.usecase.port.output.ShowOutput;
import com.codurance.training.tasks.usecase.port.output.UseCaseOutput;

public class ShowController implements ConsoleController {
    private final UseCase<ShowInput, ShowOutput> showUseCase;

    public ShowController(UseCase<ShowInput, ShowOutput> showUseCase) {
        this.showUseCase = showUseCase;
    }

    @Override
    public ConsolePresenter handle(String consoleCommand) {
        UseCaseOutput output = showUseCase.execute(new ShowInput());
        return new ConsolePresenter(output.getOutput());
    }
}
