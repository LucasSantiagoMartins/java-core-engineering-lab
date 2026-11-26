
    package com.lucas.engineering.lab.task;

    public class Task {

        private final String name;
        private final String description;
        private final ExecutableTask executableTask;

        private TaskStatus status;

        public Task(
                String name,
                String description,
                ExecutableTask executableTask) {
            this.name = name;
            this.description = description;
            this.executableTask = executableTask;
            this.status = TaskStatus.PENDING;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public TaskStatus getStatus() {
            return status;
        }


        public void execute() {
            executableTask.execute();
        }

        public void start() {
            if (status != TaskStatus.PENDING) {
                throw new IllegalStateException("Only pending tasks can be started.");
            }
            status = TaskStatus.RUNNING;
        }

        public void complete() {
            if (status != TaskStatus.RUNNING) {
                throw new IllegalStateException("Only running tasks can be completed.");
            }
            status = TaskStatus.COMPLETED;
        }

        public void fail() {
            if (status != TaskStatus.RUNNING) {
                throw new IllegalStateException("Only running tasks can be failed.");
            }
            status = TaskStatus.FAILED;
        }
    }
