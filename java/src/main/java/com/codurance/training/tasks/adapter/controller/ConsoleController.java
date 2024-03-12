package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;
import com.codurance.training.tasks.usecase.*;
import com.codurance.training.tasks.usecase.port.output.UseCaseOutput;

public interface ConsoleController {
    public ConsolePresenter handle(String consoleCommand);
}
