package com.sandbox.scheduler;

import com.sandbox.scheduler.model.Category;
import com.sandbox.scheduler.model.Task;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pchurchward on 2017-07-20.
 */
public class App {

    public static void main(String[] args) {
        Task task1 = new Task(0, Category.RED, LocalTime.of(12, 0));
        Task task2 = new Task(0, Category.RED, LocalTime.of(12, 1));
        Task task3 = new Task(3, Category.RED, LocalTime.of(12, 5));
        Task task4 = new Task(1, Category.GREEN, LocalTime.of(12, 6));

        List<Task> unsorted = Arrays.asList(task1, task2, task3, task4);

        unsorted.forEach(t -> Scheduler.scheduleTask(t));

        Scheduler.printSchedule();
    }
}
