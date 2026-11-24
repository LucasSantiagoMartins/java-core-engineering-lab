
# Java Core Engineering Lab

A hands-on Java engineering laboratory focused on understanding the language, its runtime, data structures, memory management, and concurrent programming through practical software engineering challenges.

## Overview

This project explores Java beyond syntax and basic programming exercises.

The main objective is to develop a deeper understanding of Java and its runtime environment by designing and implementing a concurrent job processing engine from scratch, without relying on application frameworks such as Spring Boot.

The project emphasizes understanding how Java works internally, making informed engineering decisions, and applying core language concepts to real-world backend problems.

## Main Project: Concurrent Job Processing Engine

The laboratory will progressively build a reusable task processing engine capable of:

- Registering and managing tasks.
- Supporting task priorities and scheduling.
- Processing multiple tasks concurrently.
- Tracking task execution states.
- Supporting task cancellation.
- Handling execution failures and retries.
- Producing processing statistics.

The engine will serve as a practical environment for exploring Java fundamentals and concurrency.

## Learning Objectives

### Java Core & Object-Oriented Programming
- Classes, interfaces, and abstractions.
- Encapsulation, inheritance, and composition.
- Records, enums, and immutability.
- Generics and exception handling.

### Collections & Data Structures
- Java Collections Framework.
- List, Set, Map, and Queue.
- HashMap and HashSet internals.
- equals() and hashCode().
- Comparable and Comparator.
- Streams and Collectors.

### JVM & Memory Management
- JVM architecture and execution lifecycle.
- Stack and Heap memory.
- Garbage Collection.
- Object lifecycle and memory profiling.

### Concurrency & Asynchronous Programming
- Threads and Runnable.
- Callable and Future.
- ExecutorService and ThreadPoolExecutor.
- Synchronization and thread safety.
- Race conditions and deadlocks.
- Locks and atomic variables.
- CompletableFuture.

### Testing & Performance
- Unit testing with JUnit 5.
- Mocking with Mockito.
- Concurrency testing.
- Performance benchmarking with JMH.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 25 LTS | Core programming language |
| Maven | Build and dependency management |
| Maven Wrapper | Reproducible Maven execution |
| JUnit 5 | Automated testing |
| Mockito | Mocking and test isolation |
| JMH | Performance benchmarking |
| IntelliJ IDEA | Development environment |

## Project Structure

```text
java-core-engineering-lab/
├── src/
│   ├── main/java/
│   └── test/java/
├── benchmarks/
├── docs/
│   ├── architecture/
│   └── learning/
├── .mvn/
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Development

### Prerequisites

- JDK 25 or compatible Java 25 distribution.
- Git.

Maven is provided through the Maven Wrapper.

### Build

```bash
./mvnw clean compile
```

### Run tests

```bash
./mvnw test
```

## Engineering Principles

This laboratory follows a few fundamental principles:

- Understand before implementing.
- Prefer composition over unnecessary inheritance.
- Favor immutability where appropriate.
- Write testable and maintainable code.
- Understand performance trade-offs.
- Avoid unnecessary abstractions.
- Prefer standard Java APIs before introducing external libraries.

## Project Status

Currently in the initial setup and Java Core learning phase.

The implementation will evolve progressively as new concepts are studied and applied.

## License

This project is licensed under the MIT License.
