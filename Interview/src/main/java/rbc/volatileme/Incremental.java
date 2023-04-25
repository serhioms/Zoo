package rbc.volatileme;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Incremental {

	volatile public int syncVolatileCounter = 0;
	public int syncNonVolatileCounter = 0;
	public int asyncCounter = 0;
	volatile public int asyncVolatileCounter = 0;

	public AtomicInteger atomicCounter = new AtomicInteger(0);

	volatile public int lockVolatileCounter = 0;
	public int lockNonVolatileCounter = 0;
	
	private ReentrantLock lock = new ReentrantLock();
	
	public long incrementLockVolatile(int n) {
		try {
			lock.lock();
			long start = System.currentTimeMillis();
			while( --n >=0 ) ++lockVolatileCounter;
			return System.currentTimeMillis() - start;
		} finally {
			lock.unlock();
		}
	}
	
	public long incrementLockNonVolatile(int n) {
		try {
			lock.lock();
			long start = System.currentTimeMillis();
			while( --n >=0 ) ++lockNonVolatileCounter;
			return System.currentTimeMillis() - start;
		} finally {
			lock.unlock();
		}
	}
	
	synchronized public long incrementSynchVolatile(int n) {
		long start = System.currentTimeMillis();
		while( --n >=0 ) ++syncVolatileCounter;
		return System.currentTimeMillis() - start;
	}
	
	synchronized public long incrementSynchNonVolatile(int n) {
		long start = System.currentTimeMillis();
		while( --n >=0 ) ++syncNonVolatileCounter;
		return System.currentTimeMillis() - start;
	}
	
	public long incrementAsynchNonVolatile(int n) {
		long start = System.currentTimeMillis();
		while( --n >=0 ) ++asyncCounter;
		return System.currentTimeMillis() - start;
	}
	
	public long incrementAsynchVolatile(int n) {
		long start = System.currentTimeMillis();
		while( --n >=0 ) ++asyncVolatileCounter;
		return System.currentTimeMillis() - start;
	}
	
	public long incrementAtomic(int n) {
		long start = System.currentTimeMillis();
		while( --n >=0 ) atomicCounter.incrementAndGet();
		return System.currentTimeMillis() - start;
	}
}
