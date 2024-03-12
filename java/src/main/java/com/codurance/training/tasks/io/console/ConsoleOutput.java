package com.codurance.training.tasks.io.console;

import java.io.PrintWriter;

public class ConsoleOutput {
    private final PrintWriter writer;

    public ConsoleOutput(PrintWriter printWriter) {
        this.writer = printWriter;
    }

    public void Prompt() {
        writer.print("> ");
        writer.flush();
    }

    public void show(String output) {
        writer.printf(output);
    }

}
