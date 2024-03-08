package com.codurance.training.tasks.io;

import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.io.console.ConsoleInput;
import com.codurance.training.tasks.io.console.ConsoleOutput;
import com.codurance.training.tasks.usecase.CommandUseCase;
import com.codurance.training.tasks.usecase.factory.CommandUseCaseFactory;
import com.codurance.training.tasks.usecase.factory.UseCaseFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public final class TaskListApp implements Runnable {

    private final TaskList taskList = new TaskList();
    private static final String QUIT = "quit";
    private final ConsoleInput input;
    private final ConsoleOutput output;
    private final UseCaseFactory useCaseFactory = new CommandUseCaseFactory();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskListApp(in, out).run();
    }

    public TaskListApp(BufferedReader reader, PrintWriter writer) {
        this.input = new ConsoleInput(reader);
        this.output = new ConsoleOutput(writer);
    }

    public void run() {
        while (true) {
            output.Prompt();
            String command;
            try {
                command = input.nextInput();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandLine) {
        CommandUseCase useCase = useCaseFactory.createUseCase(commandLine);
        String result = useCase.execute(taskList);
        if(!result.equals("ok")) {
            output.show(result);
        }
    }

}
