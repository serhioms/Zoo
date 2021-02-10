package ca.interview.rbc.transactions;

public class NotificationManager {

	// Very fast!
	java.util.LinkedList<Transaction> list = new java.util.LinkedList<>(); 
	
	// 10 times slower!
	//java.util.concurrent.ConcurrentLinkedDeque<Transaction> list = new java.util.concurrent.ConcurrentLinkedDeque<>();
	
	int accsum = 0;
	
	public boolean isOverLimit(Transaction transaction, long timeline) {
		try {
			int[] expiredData = expiredSynch(timeline, transaction);
			// +1 for finally { *** }
			return transaction.isOverLimit(expiredData[0], expiredData[1]);
		} finally {
			// Add new transaction sum to the tail of list asynchronously
			list.addLast(transaction);
		}
	}

	synchronized public int[] expiredSynch(long timeline, Transaction transaction) {
		// Add new transaction sum
		accsum += transaction.sum;
		
		// Remove expired transaction from the head of list
		while( !list.isEmpty() ) {
			if( list.getFirst().expired < timeline ) {
				accsum -= list.removeFirst().sum;
				++transaction.accremexp;
			} else {
				break;
			}
		}
		return new int[] {accsum, list.size()+1};
	}

}
