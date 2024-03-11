package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.usecase.port.input.HelpInput;
import com.codurance.training.tasks.usecase.port.output.HelpOutput;

public class HelpUseCase implements UseCase<HelpInput, HelpOutput> {
    public HelpUseCase() {}

    @Override
    public HelpOutput execute(HelpInput input) {
        HelpOutput output = new HelpOutput();
        String message = "Commands:" +
                System.lineSeparator() +
                "  show" +
                System.lineSeparator() +
                "  add project <project name>" +
                System.lineSeparator() +
                "  add task <project name> <task description>" +
                System.lineSeparator() +
                "  check <task ID>" +
                System.lineSeparator() +
                "  uncheck <task ID>" +
                System.lineSeparator() +
                System.lineSeparator();
        output.setMessage(message);
        return output;
    }
}
