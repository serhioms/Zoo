package ca.interview.rbc.transactions;

public class NotificationManager {

	// Very fast!
	java.util.LinkedList<Transaction> list = new java.util.LinkedList<>(); 
	
	// 10 times slower!
	//java.util.concurrent.ConcurrentLinkedDeque<Transaction> list = new java.util.concurrent.ConcurrentLinkedDeque<>();
	
	int accSum = 0;
	
	synchronized public boolean isOverLimitSequentially(Transaction transaction, long timeline) {
		return isOverLimit(transaction, timeline);
	}

	public boolean isOverLimit(Transaction transaction, long timeline) {

		// Add new transaction to the tail
		list.addLast(transaction); 
		accSum += transaction.transactionSum;
		
		// Remove expired transaction from the head
		while( !list.isEmpty() ) {
			if( list.getFirst().expiredMls < timeline ) {
				accSum -= list.removeFirst().transactionSum;
				++transaction.numExpired; // for print
			} else {
				break; // transactions are sorted by expire date
			}
		}
		
		return transaction.isOverLimit(accSum, list.size());
	}

}
