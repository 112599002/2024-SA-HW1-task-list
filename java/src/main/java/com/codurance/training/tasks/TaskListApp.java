package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskListApp implements Runnable {

    private final TaskList taskList = new TaskList();
    private static final String QUIT = "quit";
    private final Input input;
    private final Output output;

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
            output.showPrompt();
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
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                show();
                break;
            case "add":
                add(commandRest[1]);
                break;
            case "check":
                checkTask(commandRest[1]);
                break;
            case "uncheck":
                uncheckTask(commandRest[1]);
                break;
            case "help":
                help();
                break;
            default:
                error(command);
                break;
        }
    }

    private void show() {
        Map<String, List<Task>> tasks = taskList.getAllTasks();
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            output.showln(project.getKey());
            for (Task task : project.getValue()) {
                output.showTaskInfo(task.isDone(), task.getId(), task.getDescription());
            }
            output.newLine();
        }
    }

    private void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1]);
        }
    }

    private void addProject(String name) {
        taskList.addProject(name);
    }

    private void addTask(String project, String description) {
        List<Task> projectTasks = taskList.getProject(project);
        if (projectTasks == null) {
            String projectNotFound = String.format("Could not find a project with the name \"%s\".", project);
            output.showln(projectNotFound);
            return;
        }
        taskList.addTask(project, description);
    }

    private void checkTask(String idString) {
        int id = Integer.parseInt(idString);
        Task task = taskList.getTask(id);
        if (task == null) {
            String taskNotFound = String.format("Could not find a task with an ID of %d.", id);
            output.showln(taskNotFound);
            return;
        }
        taskList.check(task);
    }

    private void uncheckTask(String idString) {
        int id = Integer.parseInt(idString);
        Task task = taskList.getTask(id);
        if (task == null) {
            String taskNotFound = String.format("Could not find a task with an ID of %d.", id);
            output.showln(taskNotFound);
            return;
        }
        taskList.uncheck(task);
    }

    private void help() {
        output.showln("Commands:");
        output.showln("  show");
        output.showln("  add project <project name>");
        output.showln("  add task <project name> <task description>");
        output.showln("  check <task ID>");
        output.showln("  uncheck <task ID>");
        output.newLine();
    }

    private void error(String command) {
        String error = String.format("I don't know what the command \"%s\" is.", command);
        output.showln(error);
    }

}
