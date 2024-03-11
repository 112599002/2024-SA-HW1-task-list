package com.codurance.training.tasks.usecase.port.output;

public class UncheckOutput implements UseCaseOutput{
    private String message;

    public UncheckOutput() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
