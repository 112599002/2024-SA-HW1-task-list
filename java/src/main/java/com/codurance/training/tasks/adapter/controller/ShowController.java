package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;

public class ShowController implements ConsoleController {
    public ShowController() {}

    @Override
    public ConsolePresenter handle(String consoleCommand) {
        return null;
    }
}
