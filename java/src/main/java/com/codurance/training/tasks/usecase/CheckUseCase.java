package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.port.input.CheckInput;
import com.codurance.training.tasks.usecase.port.output.CheckOutput;

public class CheckUseCase implements UseCase<CheckInput, CheckOutput> {
    public CheckUseCase() {}

    @Override
    public CheckOutput execute(CheckInput input) {
        int taskId = input.getTaskId();
        TaskList taskList = TaskList.getTaskList();

        CheckOutput output = new CheckOutput();

        Task task = taskList.getTask(taskId);
        if (task == null) {
            String message = String.format("Could not find a task with an ID of %d.%n", taskId);
            output.setMessage(message);
            return output;
        }

        taskList.check(taskId);
        if (task.isDone()) {
            output.setMessage("success");
            return output;
        }

        String message = String.format("Check task with an ID of %d failed.%n", taskId);
        output.setMessage(message);
        return output;
    }
}
