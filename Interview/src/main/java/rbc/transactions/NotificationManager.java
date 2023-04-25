package rbc.transactions;

public class NotificationManager {

	// Very fast!
	java.util.LinkedList<Transaction> list = new java.util.LinkedList<>(); 
	
	// 10 times slower!
	//java.util.concurrent.ConcurrentLinkedDeque<Transaction> list = new java.util.concurrent.ConcurrentLinkedDeque<>();
	
	int accSum = 0;
	
	synchronized public boolean isOverLimitSequentially(Transaction transaction, long startTransaction) {
		return isOverLimit(transaction, startTransaction);
	}

	public boolean isOverLimit(Transaction transaction, long startTransaction) {

		// Remove expired transaction from the head
		if( list.size() == 0 ) {
		} else if( list.getLast().expiredMls < startTransaction ) {
			list.clear();
			accSum = 0;
		} else {
			while( !list.isEmpty() ) {
				if( list.getFirst().expiredMls < startTransaction ) {
					accSum -= list.removeFirst().transactionSum;
					++transaction.numExpired; // for print
				} else {
					break; // transactions are sorted by expire date
				}
			}
		}
		
		// Add new transaction to the tail
		list.addLast(transaction); 
		accSum += transaction.transactionSum;
		
		return transaction.isOverLimit(accSum, list.size());
	}

	
}
