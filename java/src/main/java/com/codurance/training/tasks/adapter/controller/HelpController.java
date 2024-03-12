package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;

public class HelpController implements ConsoleController {
    public HelpController() {}

    @Override
    public ConsolePresenter handle(String consoleCommand) {
        return null;
    }
}
