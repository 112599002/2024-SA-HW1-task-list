package com.codurance.training.tasks.adapter.presenter;

public class ConsolePresenter {
    private final boolean isPresent;
    private final String view;

    public ConsolePresenter(String stringView) {
        if (stringView.equals("success.")) {
            this.isPresent = false;
        } else {
            this.isPresent = true;
        }
        this.view = stringView;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public String getView() {
        return view;
    }
}
