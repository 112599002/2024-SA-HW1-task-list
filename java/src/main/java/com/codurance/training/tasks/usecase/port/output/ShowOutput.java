package com.codurance.training.tasks.usecase.port.output;

public class ShowOutput implements UseCaseOutput {
    private String message;

    @Override
    public String getOutput() {
        return getMessage();
    }

    public ShowOutput() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
