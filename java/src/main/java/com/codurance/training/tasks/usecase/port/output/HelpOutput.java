package com.codurance.training.tasks.usecase.port.output;

public class HelpOutput implements UseCaseOutput {
    private String message;

    public HelpOutput() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
