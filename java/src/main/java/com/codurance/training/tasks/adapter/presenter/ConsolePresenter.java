package com.codurance.training.tasks.adapter.presenter;

public class ConsolePresenter {
    private final boolean isPresent;
    private final String view;

    public ConsolePresenter(boolean present, String stringView) {
        this.isPresent = present;
        this.view = stringView;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public String getView() {
        return view;
    }
}
