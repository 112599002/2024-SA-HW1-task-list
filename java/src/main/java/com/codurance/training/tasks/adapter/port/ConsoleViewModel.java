package com.codurance.training.tasks.adapter.port;

public class ConsoleViewModel {
    private final String message;

    public ConsoleViewModel(String useCaseOutput) {
        this.message = useCaseOutput;
    }

    public String getMessage() {
        return message;
    }
}
