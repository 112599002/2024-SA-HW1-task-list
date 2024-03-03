# Task List &nbsp; [![Build Status](https://travis-ci.org/codurance/task-list.png)](https://travis-ci.org/codurance/task-list)

2024/03/03
- Rearrange classes to following packages.
  - io: `Input`, `Output`
  - tasklist: `Task`, `Tasklist`
  - usecase: `CommandUseCase(Interface)`, polymorphic UseCases
  - usecase/factory: `UseCaseFactory(Interface)`, `CommandUseCaseFactory`
