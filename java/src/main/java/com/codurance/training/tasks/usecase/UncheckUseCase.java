package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.port.input.UncheckInput;
import com.codurance.training.tasks.usecase.port.output.UncheckOutput;

public class UncheckUseCase implements UseCase<UncheckInput, UncheckOutput> {
    public UncheckUseCase() {}

    @Override
    public UncheckOutput execute(UncheckInput input) {
        int taskId = input.getTaskId();
        TaskList taskList = TaskList.getTaskList();

        UncheckOutput output = new UncheckOutput();

        Task task = taskList.getTask(taskId);
        if (task == null) {
            String message = String.format("Could not find a task with an ID of %d.%n", taskId);
            output.setMessage(message);
            return output;
        }

        taskList.uncheck(taskId);
        if (!task.isDone()) {
            output.setMessage("success");
            return output;
        }

        String message = String.format("Check task with an ID of %d failed.%n", taskId);
        output.setMessage(message);
        return output;
    }
}
