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

    public void showln(String output) {
        writer.printf(output);
        newLine();
    }

    public void newLine() {
        writer.println();
    }

    public void taskInfo(boolean isDone, long id, String description) {
        writer.printf("    [%c] %d: %s", (isDone ? 'x' : ' '), id, description);
        newLine();
    }

    public void projectNotFound(String project) {
        writer.printf("Could not find a project with the name \"%s\".", project);
        newLine();
    }

    public void taskNotFound(int id) {
        writer.printf("Could not find a task with an ID of %d.", id);
        newLine();
    }

    public void help() {
        writer.println("Commands:");
        writer.println("  show");
        writer.println("  add project <project name>");
        writer.println("  add task <project name> <task description>");
        writer.println("  check <task ID>");
        writer.println("  uncheck <task ID>");
        writer.println();
    }

    public void error(String command){
        writer.printf("I don't know what the command \"%s\" is.", command);
        newLine();
    }
}
