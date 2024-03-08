# Task List &nbsp; [![Build Status](https://travis-ci.org/codurance/task-list.png)](https://travis-ci.org/codurance/task-list)

2024/03/03
- Rearrange classes to following packages.
  - io: `Input`, `Output`
  - tasklist: `Task`, `Tasklist`
  - usecase: `CommandUseCase(Interface)`, polymorphic UseCases
  - usecase/factory: `UseCaseFactory(Interface)`, `CommandUseCaseFactory`

`ui` layer contains framework and user interface.

`adapter` layer contains controller, presenter, view. Convert external form data to internal form used by use cases and entities.

dependency rule: `io`->`adapter`->`usecase`->`entity`

**note: 先從最內層開始做**