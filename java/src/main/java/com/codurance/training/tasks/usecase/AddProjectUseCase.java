package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Project;
import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.port.input.AddProjectInput;
import com.codurance.training.tasks.usecase.port.output.AddProjectOutput;

public class AddProjectUseCase implements UseCase<AddProjectInput, AddProjectOutput> {
    public AddProjectUseCase() {}

    @Override
    public AddProjectOutput execute(AddProjectInput input) {
        String projectName = input.getProjectName();
        TaskList taskList = TaskList.getTaskList();
        taskList.addProject(projectName);

        Project newProject = taskList.getProject(projectName);
        AddProjectOutput output = new AddProjectOutput();

        if (newProject == null) {
            String message = String.format("Add project \"%s\" failed.%n", projectName);
            output.setProjectId(-1);
            output.setMessage(message);
            return output;
        }

        output.setProjectId(newProject.id());
        output.setMessage("success");
        return output;
    }
}
