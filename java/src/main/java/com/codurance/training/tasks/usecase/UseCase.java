package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.tasklist.TaskList;

public interface UseCase {
    public String execute(TaskList taskList);
}
