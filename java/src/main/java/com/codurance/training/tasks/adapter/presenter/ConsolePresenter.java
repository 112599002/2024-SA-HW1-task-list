package com.codurance.training.tasks.adapter.presenter;

public class ConsolePresenter {
    private final boolean isPresent;
    private final String view;

    public ConsolePresenter(String stringView) {
        this.isPresent = !stringView.equals("success");
        this.view = stringView;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public String getView() {
        return view;
    }
}
