package com.codurance.training.tasks.io;

import java.io.PrintWriter;

public class Output {

    private final PrintWriter writer;

    public Output(PrintWriter printWriter) {
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
