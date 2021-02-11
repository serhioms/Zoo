package ca.interview.rbc.transactions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.lmax.disruptor.RingBuffer;

public class TransactionManager {

	public int transactionCounter = 0;
	public int notificationCounter = 0;

	public Map<String, NotificationManager> map = new HashMap<>();
	public Map<String, NotificationManager> concurrentMap = new ConcurrentHashMap<>();
	
	public TransactionManager() {
	}

	synchronized public long[] processSequentially(Transaction transaction, long startTest) {
		long startTransaction = System.currentTimeMillis();
		++transactionCounter;

		transaction.setExpired(startTransaction); 

		// All transactions process sequentially in diff threads 
		if( getNotificationManager(transaction).isOverLimit(transaction, startTransaction) ) {
			notify(transaction, startTransaction, startTest);
		}
		
		long endTransaction = System.currentTimeMillis();
		return new long[]{startTransaction, endTransaction};
	}

	Object transactionCounterMonitor = new Object();
	
	public long[] processConcurrently(Transaction transaction, long startTest) {
		
		synchronized ( transactionCounterMonitor ){
			++transactionCounter;
		}

		long startTransaction = System.currentTimeMillis();

		transaction.setExpired(startTransaction); 

		// Transactions for diff accounts process concurrently/asynchronously
		if( getNotificationManagerConcurrently(transaction).isOverLimitSequentially(transaction, startTransaction) ) {
			notify(transaction, startTransaction, startTest);
		}
		
		long endTransaction = System.currentTimeMillis();
		return new long[]{startTransaction, endTransaction};
	}

	public Set<String> notifiedAccounts = new HashSet<>(Transaction.TOTAL_ACCOUNTS);
	public Set<String> notifiedTimeSlots = new HashSet<>(Transaction.TOTAL_ACCOUNTS*10);
	
	Object notificationCounterMonitor = new Object();

	public void notify(Transaction transaction, long startTransaction, long startTest) {
		long timeslotNum = (startTransaction - startTest)/Transaction.TIME_FRAME_MLS;
		String account = transaction.accountIdent;
		String key = account+":"+timeslotNum;
		if( !notifiedTimeSlots.contains(key) ) {
			synchronized( notificationCounterMonitor ) {
				++notificationCounter;
				notifiedAccounts.add(transaction.accountIdent);
				notifiedTimeSlots.add(key);
			}
			// Do not print all notifications but only most interesting which include expired transactions
			if( transaction.numExpired > 0 ) {
				System.out.printf("%3s) time slot=%2d Acc%3s = $%,d > $%,d (total %d - %d expired)\n", notificationCounter+"", timeslotNum, account, transaction.accSum, Transaction.SUM_LIMIT, transaction.sizeList, transaction.numExpired);
			}
		}
	}

	public NotificationManager getNotificationManager(Transaction transaction) {
		NotificationManager nman = map.get(transaction.accountIdent);
		if( nman == null ) {
			nman = new NotificationManager(); 
			map.put(transaction.accountIdent, nman);
		}
		return nman;
	}

	Object mapAsynchMonitor = new Object();

	public NotificationManager getNotificationManagerConcurrently(Transaction transaction) {
		NotificationManager nman = concurrentMap.get(transaction.accountIdent);
		if( nman == null ) {
			synchronized(mapAsynchMonitor) {
				nman = concurrentMap.get(transaction.accountIdent);
				if( nman == null ) {
					nman = new NotificationManager(); 
					concurrentMap.put(transaction.accountIdent, nman);
				}
			}
		}
		return nman;
	}

	
	synchronized public long[] publishLmax(RingBuffer<Transaction> ringBuffer, long startTest) {
		
		synchronized ( transactionCounterMonitor ){
			++transactionCounter;
		}

		long startTransaction = System.currentTimeMillis();

		// Publish transaction to disrupter ring buffer
        long seq = ringBuffer.next();
        	Transaction transaction = ringBuffer.get(seq);
        		transaction.startMls = startTransaction; 
    			transaction.startTestMls = startTest; 
        		transaction.setExpired(startTransaction); 
        		transaction.transactionSum = 6; 
        ringBuffer.publish(seq);
		
		long endTransaction = System.currentTimeMillis();
		return new long[]{startTransaction, endTransaction};
	}

}
