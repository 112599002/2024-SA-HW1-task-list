package com.codurance.training.tasks.usecase.port;

public class UseCaseOutput {
    private final String output;

    public UseCaseOutput(String usecaseOutput) {
        this.output = usecaseOutput;
    }

    public String getOutput() {
        return output;
    }

}
