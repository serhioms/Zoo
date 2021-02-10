package ca.interview.rbc.transactions;

public class NotificationManager {

	java.util.LinkedList<Transaction> linkedList = new java.util.LinkedList<>(); 
	//java.util.concurrent.ConcurrentLinkedDeque<Transaction> list = new java.util.concurrent.ConcurrentLinkedDeque<>();
	
	int accsum = 0;
	
	public boolean isOverLimit(Transaction transaction, long timeline) {
		try {
			int addSum = transaction.sum;
			int[] removeSumListSize = processSynch(timeline, transaction);
			return transaction.isOverLimit(removeSumListSize[0]+addSum, removeSumListSize[1]+1);
		} finally {
			linkedList.add(transaction);
		}
	}

	synchronized public int[] processSynch(long timeline, Transaction transaction) {
		// Add new transaction sum to the tail of list
		accsum += transaction.sum;
		// Remove expired transaction from the head of list
		while( !linkedList.isEmpty() ) {
			if( linkedList.getFirst().expired < timeline ) {
				accsum -= linkedList.removeFirst().sum;
				++transaction.accexp;
			} else {
				break;
			}
		}
		return new int[] {accsum, linkedList.size()};
	}

}
