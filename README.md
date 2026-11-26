<div align="center">

# Java Core Engineering Lab

**Concurrent Job Processing Engine, built from scratch with no frameworks.**

`Java 25` · `Concurrency` · `JVM Internals` · `Collections` · `Generics` · `Streams` · `CompletableFuture` · `Thread Safety` · `Garbage Collection` · `JMH Benchmarks`

<br>

<img src="https://skillicons.dev/icons?i=java,maven,idea,vscode,git,github,linux&perline=7" alt="Technology stack" />

</div>

---

## Overview

A hands-on Java engineering laboratory focused on understanding the language, its runtime, data structures, memory management, and concurrent programming through practical software engineering challenges.

This project explores Java beyond syntax and basic exercises. The goal is to build a deeper understanding of how Java works internally by designing and implementing a **concurrent job processing engine from scratch**, without relying on application frameworks such as Spring Boot.

The emphasis is on making informed engineering decisions and applying core language concepts to real-world backend problems.

---

## Main Project: Concurrent Job Processing Engine

The laboratory progressively builds a reusable task processing engine capable of:

- Registering and managing tasks
- Supporting task priorities and scheduling
- Processing multiple tasks concurrently
- Tracking execution states (`PENDING`, `RUNNING`, `COMPLETED`, `FAILED`)
- Supporting task cancellation
- Handling failures and retries
- Producing processing statistics

The engine is the practical environment used to explore Java fundamentals and concurrency.

---

## Learning Objectives

<details open>
<summary><b>Java Core and Object-Oriented Programming</b></summary>

- Classes, interfaces, and abstractions
- Encapsulation, inheritance, and composition
- Records, enums, and immutability
- Generics and exception handling

</details>

<details open>
<summary><b>Collections and Data Structures</b></summary>

- Java Collections Framework
- `List`, `Set`, `Map`, and `Queue`
- `HashMap` and `HashSet` internals
- `equals()` and `hashCode()`
- `Comparable` and `Comparator`
- Streams and Collectors

</details>

<details open>
<summary><b>JVM and Memory Management</b></summary>

- JVM architecture and execution lifecycle
- Stack and Heap memory
- Garbage Collection
- Object lifecycle and memory profiling

</details>

<details open>
<summary><b>Concurrency and Asynchronous Programming</b></summary>

- Threads and `Runnable`
- `Callable` and `Future`
- `ExecutorService` and `ThreadPoolExecutor`
- Synchronization and thread safety
- Race conditions and deadlocks
- Locks and atomic variables
- `CompletableFuture`

</details>

<details open>
<summary><b>Testing and Performance</b></summary>

- Unit testing with JUnit 5
- Mocking with Mockito
- Concurrency testing
- Performance benchmarking with JMH

</details>

---

## Engineering Questions This Lab Answers

| # | Question | Concept |
|:-:|---|---|
| 1 | How do we guarantee two threads never execute the same task at once? | Concurrency |
| 2 | Which data structure best supports lookup by ID, priorities, and no duplicates? | Collections |
| 3 | How do we prevent a task from being modified while it is running? | Immutability |
| 4 | How do we run three independent operations in parallel and combine results? | `CompletableFuture` |
| 5 | What happens to the JVM with thousands of tasks held in memory? | JVM / GC |

---

## Project Structure

```text
java-core-engineering-lab/
├── src/
│   ├── main/java/        # Engine source code
│   └── test/java/        # Unit and concurrency tests
├── benchmarks/           # JMH benchmarks
├── docs/
│   ├── architecture/     # Design decisions and diagrams
│   └── learning/         # Study notes per concept
├── .mvn/                 # Maven Wrapper config
├── mvnw
├── mvnw.cmd
├── pom.xml
├── CONTRIBUTING.md
├── LICENSE
└── README.md
```

---

## Development

### Prerequisites

- JDK 25 (or a compatible Java 25 distribution)
- Git

Maven is provided through the Maven Wrapper, so no local installation is needed.

### Build

```bash
./mvnw clean compile
```

### Run tests

```bash
./mvnw test
```

---

## Engineering Principles

- Understand before implementing.
- Prefer composition over unnecessary inheritance.
- Favor immutability where appropriate.
- Write testable and maintainable code.
- Understand performance trade-offs.
- Avoid unnecessary abstractions.
- Prefer standard Java APIs before introducing external libraries.

---

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

---

## Roadmap

| Phase | Focus | Status |
|:-:|---|:-:|
| 1 | Project setup, repository, README, Maven Wrapper | Done |
| 2 | Task model: `Task`, `ExecutableTask`, `TaskStatus` | Done |
| 3 | In-memory task registry with ID lookup and duplicate protection | Done |
| 4 | FIFO task queue with `Queue` and `ArrayDeque` | Done |
| 5 | Task execution lifecycle and result tracking | Done |
| 6 | Task scheduling: submit, register, queue, and execute tasks sequentially | Done |
| 7 | Priority scheduling with `PriorityQueue` and `Comparator` | Planned |
| 8 | Concurrent execution with `ExecutorService` and thread safety | Planned |
| 9 | Cancellation, retries, and failure handling | Planned |
| 10 | `CompletableFuture` composition and statistics with Streams | Planned |
| 11 | JVM profiling, GC analysis, and JMH benchmarks | Planned |
---

## Project Status

Currently in the **initial setup and Java Core learning phase**. The implementation evolves progressively as new concepts are studied and applied.

---

## License

This project is licensed under the [MIT License](LICENSE).