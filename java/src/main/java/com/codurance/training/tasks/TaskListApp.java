package com.codurance.training.tasks;

import com.codurance.training.tasks.io.Input;
import com.codurance.training.tasks.io.Output;
import com.codurance.training.tasks.tasklist.TaskList;
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
    private final Input input;
    private final Output output;
    private final UseCaseFactory useCaseFactory = new CommandUseCaseFactory();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskListApp(in, out).run();
    }

    public TaskListApp(BufferedReader reader, PrintWriter writer) {
        this.input = new Input(reader);
        this.output = new Output(writer);
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
