package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.port.input.ShowInput;
import com.codurance.training.tasks.usecase.port.output.ShowOutput;

import java.util.List;
import java.util.Map;

public class ShowUseCase implements UseCase<ShowInput, ShowOutput> {
    public ShowUseCase() {}

    @Override
    public ShowOutput execute(ShowInput input) {
        TaskList taskList = TaskList.getTaskList();
        Map<String, List<Task>> tasks = taskList.getAllTasks();

        ShowOutput output = new ShowOutput();

        if(tasks.isEmpty()) {
            output.setMessage("");
            return output;
        }

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            builder.append(project.getKey());
            builder.append(System.lineSeparator());
            for (Task task : project.getValue()) {
                String info = taskInfo(task.isDone(), task.getId(), task.getDescription());
                builder.append(info);
                builder.append(System.lineSeparator());
            }
            builder.append(System.lineSeparator());
        }
        String message = builder.toString();
        output.setMessage(message);
        return output;
    }

    private String taskInfo(boolean isDone, long id, String description) {
        return String.format("    [%c] %d: %s", (isDone ? 'x' : ' '), id, description);
    }
}
