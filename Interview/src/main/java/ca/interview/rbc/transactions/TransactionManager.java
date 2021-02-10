package ca.interview.rbc.transactions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionManager {

	public int transactionCounter = 0;
	public int notificationCounter = 0;

	public Map<String, NotificationManager> mapSynch = new HashMap<>();
	public Map<String, NotificationManager> mapAsynch = new ConcurrentHashMap<>();
	
	synchronized public long[] processSynch(Transaction transaction, long startTest) {
		long startTransaction = System.currentTimeMillis();
		++transactionCounter;

		transaction.setExpired(startTransaction); 

		if( getSynchNotificationManager(transaction).isOverLimit(transaction, startTransaction) ) {
			notify(transaction, startTransaction, startTest);
		}
		
		long endTransaction = System.currentTimeMillis();
		return new long[]{startTransaction, endTransaction};
	}

	Object transactionCounterMonitor = new Object();
	
	public long[] processAsynch(Transaction transaction, long startTest) {
		
		synchronized ( transactionCounterMonitor ){
			++transactionCounter;
		}

		long startTransaction = System.currentTimeMillis();

		transaction.setExpired(startTransaction); 

		if( getAsynchNotificationManager(transaction).isOverLimit(transaction, startTransaction) ) {
			notify(transaction, startTransaction, startTest);
		}
		
		long endTransaction = System.currentTimeMillis();
		return new long[]{startTransaction, endTransaction};
	}

	public Set<String> notifiedAccounts = new HashSet<>(Transaction.TOTAL_ACCOUNTS);
	public Set<String> notifiedTimeSlots = new HashSet<>(Transaction.TOTAL_ACCOUNTS*10);
	
	Object notificationCounterMonitor = new Object();

	private void notify(Transaction transaction, long startTransaction, long startTest) {
		long timeslotNum = (startTransaction - startTest)/Transaction.SELECTED_PERIOD_MLS;
		String account = transaction.accountNum;
		String key = account+":"+timeslotNum;
		if( !notifiedTimeSlots.contains(key) ) {
			synchronized( notificationCounterMonitor ) {
				++notificationCounter;
				notifiedAccounts.add(transaction.accountNum);
				notifiedTimeSlots.add(key);
			}
			if( transaction.accexp > 0 ) {
				System.out.printf("%3s) time slot=%2d Acc%3s = $%,d > $%,d (total %d - %d expired)\n", notificationCounter+"", timeslotNum, account, transaction.accsum, Transaction.SUM_LIMIT_IN_SELECTED_PERIOD, transaction.acctrans, transaction.accexp);
			}
		}
	}

	private NotificationManager getSynchNotificationManager(Transaction transaction) {
		NotificationManager nman = mapSynch.get(transaction.accountNum);
		if( nman == null ) {
			nman = new NotificationManager(); 
			mapSynch.put(transaction.accountNum, nman);
		}
		return nman;
	}

	Object mapAsynchMonitor = new Object();

	private NotificationManager getAsynchNotificationManager(Transaction transaction) {
		NotificationManager nman = mapAsynch.get(transaction.accountNum);
		if( nman == null ) {
			synchronized(mapAsynchMonitor) {
				nman = mapAsynch.get(transaction.accountNum);
				if( nman == null ) {
					nman = new NotificationManager(); 
					mapAsynch.put(transaction.accountNum, nman);
				}
			}
		}
		return nman;
	}

}
