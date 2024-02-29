package com.codurance.training.tasks;

import com.codurance.training.tasks.io.Input;
import com.codurance.training.tasks.io.Output;
import com.codurance.training.tasks.tasklist.Task;
import com.codurance.training.tasks.tasklist.TaskList;
import com.codurance.training.tasks.usecase.UseCase;
import com.codurance.training.tasks.usecase.factory.CommandUseCaseFactory;
import com.codurance.training.tasks.usecase.factory.UseCaseFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

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
        UseCase useCase = useCaseFactory.createUseCase(commandLine);
        String result = useCase.execute(taskList);
        if(!result.equals("ok")) {
            output.show(result);
        }
    }

    private void show() {
        Map<String, List<Task>> tasks = taskList.getAllTasks();
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            output.showln(project.getKey());
            for (Task task : project.getValue()) {
                output.taskInfo(task.isDone(), task.getId(), task.getDescription());
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
            output.projectNotFound(project);
            return;
        }
        taskList.addTask(project, description);
    }

    private void checkTask(String idString) {
        int id = Integer.parseInt(idString);
        Task task = taskList.getTask(id);
        if (task == null) {
            output.taskNotFound(id);
            return;
        }
        taskList.check(task);
    }

    private void uncheckTask(String idString) {
        int id = Integer.parseInt(idString);
        Task task = taskList.getTask(id);
        if (task == null) {
            output.taskNotFound(id);
            return;
        }
        taskList.uncheck(task);
    }

    private void help() {
        output.help();
    }

    private void error(String command) {
        output.error(command);
    }

}
