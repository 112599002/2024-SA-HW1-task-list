package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.usecase.port.input.UseCaseInput;
import com.codurance.training.tasks.usecase.port.output.UseCaseOutput;

public interface UseCase<I extends UseCaseInput, O extends UseCaseOutput> {
    O execute(I input);
}
