package com.codurance.training.tasks.usecase.port.input;

public class UnknownCommandInput implements UseCaseInput {
    private String command;

    public UnknownCommandInput() {}

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
