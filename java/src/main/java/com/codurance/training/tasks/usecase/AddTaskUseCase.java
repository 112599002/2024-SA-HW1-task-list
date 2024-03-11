package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.port.input.AddTaskInput;
import com.codurance.training.tasks.usecase.port.output.AddTaskOutput;

public class AddTaskUseCase implements UseCase<AddTaskInput, AddTaskOutput> {
    public AddTaskUseCase() {}

    @Override
    public AddTaskOutput execute(AddTaskInput input) {
        String projectName = input.getProjectName();
        String description = input.getDescription();
        TaskList taskList = TaskList.getTaskList();

        long newTaskId = taskList.addTask(projectName, description);
        AddTaskOutput output = new AddTaskOutput();

        if (newTaskId < 0) {
            String message = String.format("Could not find a project with the name \"%s\".%n", projectName);
            output.setTaskId(newTaskId);
            output.setMessage(message);
            return output;
        }

        Task task = taskList.getTask(newTaskId);
        if (task.getId() == newTaskId) {
            output.setTaskId(newTaskId);
            output.setMessage("success");
            return output;
        }

        String message = String.format("Add task \"%s\" failed.%n", description);
        output.setTaskId(newTaskId);
        output.setMessage(message);
        return output;
    }
}
