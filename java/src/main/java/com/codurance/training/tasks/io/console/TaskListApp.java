package com.codurance.training.tasks.io.console;

import com.codurance.training.tasks.adapter.ControllerFactory;
import com.codurance.training.tasks.adapter.controller.ConsoleController;
import com.codurance.training.tasks.adapter.presenter.ConsolePresenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public final class TaskListApp implements Runnable {
    private static final String QUIT = "quit";
    private final ConsoleInput input;
    private final ConsoleOutput output;

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
            ConsoleController controller = ControllerFactory.create(command);
            ConsolePresenter presenter = controller.handle(command);
            if (presenter.isPresent()) {
                output.show(presenter.getView());
            }
        }
    }
}
