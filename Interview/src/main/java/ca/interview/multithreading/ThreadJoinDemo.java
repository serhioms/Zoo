package ca.interview.multithreading;

import java.util.Arrays;
import java.util.Comparator;

import ca.interview.multithreading.impl.MyThread;

public class ThreadJoinDemo {

	final static private boolean SHOW_TIME = true;

	public static void main(String[] args) throws InterruptedException {
		if( SHOW_TIME) System.out.println("**************************************************************** main().start");

		MyThread[] t = new MyThread[]{
				new MyThread("#0-thread", Thread.NORM_PRIORITY),
				new MyThread("#1-thread", Thread.NORM_PRIORITY),
				new MyThread("#2-thread", Thread.NORM_PRIORITY),
				new MyThread("#3-last", Thread.NORM_PRIORITY),
			};

		long start = System.nanoTime();
		
		t[0].start();
		t[1].start();
		t[2].start();
		t[2].join(); // Until thread 2 get finished, thread4 will not run!!!
		t[3].start();

		// wait
		while( t[3].isAlive() );

		// analyze
		String[] starts = new String[t.length];
		
		// sort by start time
		Arrays.sort(t, new Comparator<MyThread>() {
			@Override
			public int compare(MyThread a, MyThread b) {
				return a.start < b.start? -1: a.start > b.start? 1: 0;
			}
		});
		
		for(int i=0,max=t.length; i<max; i++){
			starts[i] = String.format("%-10s%4d", t[i].getName(), (t[i].start-start)/1000);
		}
		

		// sort by end time
		Arrays.sort(t, new Comparator<MyThread>() {
			@Override
			public int compare(MyThread a, MyThread b) {
				return a.end < b.end? -1: a.end > b.end? 1: 0;
			}
		});
		
		System.out.printf("%14s %14s\n", "start", "end");
		System.out.printf("%14s %14s\n", "--------------", "--------------");
		for(int i=0,max=t.length; i<max; i++){
			System.out.printf("%-10s %-10s%4d\n", starts[i], t[i].getName(), (t[i].end-start)/1000);
		}
		
		if( SHOW_TIME) System.out.println("**************************************************************** main().end");
	}
}