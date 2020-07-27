package test;

import static org.junit.Assert.assertArrayEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import com.sandbox.scheduler.Scheduler;
import com.sandbox.scheduler.model.Category;
import com.sandbox.scheduler.model.Task;

public class TestScheduler {

	@Before
	public void setUp() throws Exception {
		Scheduler.tasks.clear();
	}

	@Test
	public void test() {
		
        Task task1 = new Task(0, Category.RED, LocalTime.of(12, 0));
        Task task2 = new Task(0, Category.RED, LocalTime.of(12, 1));
        Task task3 = new Task(3, Category.RED, LocalTime.of(12, 5));
        Task task4 = new Task(1, Category.GREEN, LocalTime.of(12, 6));
        Task task5 = new Task(1, Category.BLUE, LocalTime.of(12, 6));
        Task task6 = new Task(1, Category.BLUE, LocalTime.of(12, 4));

        Scheduler.scheduleTask(task1);
        Scheduler.scheduleTask(task2);
        Scheduler.scheduleTask(task3);
        Scheduler.scheduleTask(task4);
        Scheduler.scheduleTask(task5);
        Scheduler.scheduleTask(task6);

        Object[] expecteds = new Object[]{task1, task2, task4, task6, task5, task3};
        Object[] actuals = Scheduler.tasks.stream().toArray();

		assertArrayEquals(expecteds, actuals);
	}

}
