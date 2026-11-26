
package com.lucas.engineering.lab;

import com.lucas.engineering.lab.task.Task;
import com.lucas.engineering.lab.task.TaskRegistry;

public class Main {

    public static void main(String[] args) {

        TaskRegistry tasks = new TaskRegistry();

        Task emailTask = new Task(
            "Send a welcome email",
            "Welcome Email",
            () -> {}
        );

        Task paymentTask = new Task(
            "Process customer payment",
            "Process payment",
            () -> {}
        );

        Task reportTask = new Task(
            "Generate sales report",
            "Process sales data",
            () -> {}
        );

        tasks.register(emailTask);
        tasks.register(reportTask);
        tasks.register(paymentTask);

        System.out.println("Registered tasks: " + tasks.size());

        for(Task task : tasks.getAll()){
            System.out.println(task.getName() + " - " + task.getStatus());
        }
    }
}
