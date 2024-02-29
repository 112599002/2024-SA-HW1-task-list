package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.tasklist.TaskList;

public interface CommandUseCase {
    String execute(TaskList taskList);
}
