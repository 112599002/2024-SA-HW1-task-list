package com.codurance.training.tasks.usecase.factory;

import com.codurance.training.tasks.usecase.UseCase;

public interface UseCaseFactory {

    public UseCase createUseCase(String commandLine);
}
