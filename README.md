# Task List

#### 2024/03/11
- Rearrange classes to the following packages. Each class only depends on classes on the same layer or the one level higher layer.
  - `entity`: objects from problem (Task List) domain.
  - `usecase`: objects which manipulate `entity` objects to provide use cases.
  - `adapter`: controller and presenter objects for creating concrete use case objects, converting console input to the input for use cases, and converting use case output for the console to present.
  - `io`: for console I/O and console app.

- Using polymorphic `UseCase`, `UseCaseInput`, `UseCaseOutput`, and `Controller`.

- Using `ControllerFactory` to create concrete `Controller` according to command input string.

- Using `ConsolePresenter`(layer-3) to pass output string of `UseCaseOutput`(layer-2) to `ConsoleOutput`(layer-4).