package com.codurance.training.tasks.usecase.port.output;

public class UnknownCommandOutput implements UseCaseOutput {
    private String message;

    @Override
    public String getOutput() {
        return getMessage();
    }

    public UnknownCommandOutput() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
