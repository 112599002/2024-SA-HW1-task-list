package com.codurance.training.tasks.adapter.controller.factory;

import com.codurance.training.tasks.usecase.CommandUseCase;

public interface UseCaseFactory {

    CommandUseCase createUseCase(String commandLine);
}
