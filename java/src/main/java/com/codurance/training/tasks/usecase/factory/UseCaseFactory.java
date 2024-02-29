package com.codurance.training.tasks.usecase.factory;

import com.codurance.training.tasks.usecase.CommandUseCase;

public interface UseCaseFactory {

    CommandUseCase createUseCase(String commandLine);
}
