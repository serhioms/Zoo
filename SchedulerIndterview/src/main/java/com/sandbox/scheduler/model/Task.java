package com.sandbox.scheduler.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Created by pchurchward on 2017-07-20.
 */
public class Task {

    public int urgency = -1;
    public Category category;
    public LocalDateTime timestamp = LocalDateTime.now();
    public UUID uuid = UUID.randomUUID();

    public Task(int urgency, Category category, LocalTime time) {
        this.urgency = urgency;
        this.category = category;
        this.timestamp = LocalDateTime.of(LocalDate.now(), time);
	}

	public String toString() {

       return "[TASK] UUID: " + uuid.toString() + " URGENCY: " + urgency + " CATEGORY: " + category +" TIMESTAMP: " + timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (urgency != task.urgency) return false;
        if (!category.equals(task.category)) return false;
        if (timestamp != null ? !timestamp.equals(task.timestamp) : task.timestamp != null) return false;
        return uuid != null ? uuid.equals(task.uuid) : task.uuid == null;
    }

    @Override
    public int hashCode() {
        int result = urgency;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        return result;
    }
}
