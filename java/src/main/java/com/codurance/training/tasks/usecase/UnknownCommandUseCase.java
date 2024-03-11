package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.usecase.port.input.UnknownCommandInput;
import com.codurance.training.tasks.usecase.port.output.UnknownCommandOutput;

public class UnknownCommandUseCase implements UseCase<UnknownCommandInput, UnknownCommandOutput> {
    public UnknownCommandUseCase() {}

    @Override
    public UnknownCommandOutput execute(UnknownCommandInput input) {
        String command = input.getCommand();

        UnknownCommandOutput output = new UnknownCommandOutput();
        String message = String.format("I don't know what the command \"%s\" is.%n", command);
        output.setMessage(message);
        return output;
    }
}
