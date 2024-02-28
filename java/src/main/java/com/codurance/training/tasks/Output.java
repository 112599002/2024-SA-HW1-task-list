package com.codurance.training.tasks;

import java.io.PrintWriter;

public class Output {

    private final PrintWriter writer;

    public Output(PrintWriter printWriter) {
        this.writer = printWriter;
    }

    public void showPrompt() {
        writer.print("> ");
        writer.flush();
    }

    public void showln(String output) {
        writer.printf(output);
        newLine();
    }

    public void newLine() {
        writer.println();
    }

    public void showTaskInfo(boolean isDone, long id, String description) {
        writer.printf("    [%c] %d: %s", (isDone ? 'x' : ' '), id, description);
        newLine();
    }
}
