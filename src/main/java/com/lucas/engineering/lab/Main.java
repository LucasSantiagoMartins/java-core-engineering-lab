
package com.lucas.engineering.lab;

import com.lucas.engineering.lab.execution.TaskExecutor;
import com.lucas.engineering.lab.execution.TaskQueue;
import com.lucas.engineering.lab.execution.TaskScheduler;
import com.lucas.engineering.lab.task.Task;
import com.lucas.engineering.lab.task.TaskRegistry;

public class Main {

    public static void main(String[] args) {

        TaskRegistry registry = new TaskRegistry();
        TaskScheduler scheduler = new TaskScheduler(
            registry,
            new TaskQueue(),
            new TaskExecutor()
        );

        Task paymentTask = new Task(
                "Process customer payment",
                "Process payment",
                () -> 
                    System.out.println("Sending report...")
                );

        Task reportTask = new Task(
                "Generate sales report",
                "Process sales data",
                () -> 
                    System.out.println("Generating report...")
                );

        scheduler.submit(reportTask);
        scheduler.submit(paymentTask);

        System.out.println("Pending tasks: " + scheduler.pendingTasksCount());
        
        while (scheduler.pendingTasksCount() > 0)
            scheduler.executeNext();
        
        System.out.println("Pending tasks: " + scheduler.pendingTasksCount());

    }
}
