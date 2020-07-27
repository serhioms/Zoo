package com.sandbox.scheduler;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import com.sandbox.scheduler.model.Task;

public class Scheduler {

	final static public SortedSet<Task> tasks = new TreeSet<Task>(new Comparator<Task>() {
		@Override
		public int compare(Task a, Task b) {
			return a.urgency == b.urgency? 
					(a.category.getValue()==b.category.getValue()?
							 a.timestamp.compareTo(b.timestamp)
							:a.category.getValue()>b.category.getValue()?1:-1)
					:a.urgency > b.urgency? 1: -1;
		}
	});
	
	public static void scheduleTask(Task t) {
		tasks.add(t);
	}

	public static void printSchedule() {
		tasks.stream().forEach(System.out::println);
	}

}
