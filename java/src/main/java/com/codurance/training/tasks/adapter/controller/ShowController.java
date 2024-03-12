package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;
import com.codurance.training.tasks.usecase.ShowUseCase;
import com.codurance.training.tasks.usecase.UseCase;
import com.codurance.training.tasks.usecase.port.input.ShowInput;
import com.codurance.training.tasks.usecase.port.output.ShowOutput;
import com.codurance.training.tasks.usecase.port.output.UseCaseOutput;

public class ShowController implements ConsoleController {
    public ShowController() {}

    @Override
    public ConsolePresenter handle(String consoleCommand) {
        UseCase<ShowInput, ShowOutput> useCase = new ShowUseCase();
        UseCaseOutput output = useCase.execute(new ShowInput());
        return new ConsolePresenter(output.getOutput());
    }
}
