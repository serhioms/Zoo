package ca.interview.highranking;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public interface FlowRun {
	
	Runnable combine(Runnable... runnables);

	static FlowRun sequential() {
		//return runnables -> () -> {};
		return runnables -> () -> Arrays.stream(runnables).forEach(Runnable::run);
	}

	static FlowRun parallelNonBlock(Executor exe) {
		return runnables -> () -> Arrays.stream(runnables).forEach((runnable)->{
				exe.execute(runnable);
		});
	}

	static FlowRun parallelFullBlock(Executor exe) {
		return runnables -> () -> {
			try {
				CountDownLatch wateForEachParallelDoneUnlessInterrupted = new CountDownLatch(runnables.length);
				Arrays.stream(runnables).forEach( runnable -> exe.execute(() -> {
					try {
						runnable.run();
					} finally {
						wateForEachParallelDoneUnlessInterrupted.countDown();
					}
				}));
				wateForEachParallelDoneUnlessInterrupted.await();
			} catch(InterruptedException e){
				Thread.currentThread().interrupt();
			}
		};
	}
}
