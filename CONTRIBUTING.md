
# Contributing

Contributions, suggestions, and improvements are welcome.

## Development Setup

1. Clone the repository.
2. Ensure JDK 25 is installed.
3. Use the Maven Wrapper to build the project.

```bash
./mvnw clean compile
```

## Development Guidelines

- Follow standard Java naming conventions.
- Keep classes focused on a single responsibility.
- Prefer composition over unnecessary inheritance.
- Favor immutability where appropriate.
- Write tests for new behavior.
- Avoid unnecessary dependencies.
- Document important architectural decisions.

## Commit Guidelines

Use descriptive commit messages.

Examples:

- `chore: initialize Maven project`
- `docs: add project documentation`
- `feat: implement task registration`
- `test: add task lifecycle tests`
- `refactor: improve task execution design`
