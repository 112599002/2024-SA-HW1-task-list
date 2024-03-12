package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;

public class UnknownCommandController implements ConsoleController {
    public UnknownCommandController() {}

    @Override
    public ConsolePresenter handle(String consoleCommand) {
        return null;
    }
}
