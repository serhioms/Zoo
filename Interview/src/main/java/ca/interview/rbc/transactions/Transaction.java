package ca.interview.rbc.transactions;

import java.util.Random;

public class Transaction {

	public static final boolean SINGLETON = false;

	public static final int SUM_LIMIT = 10000;
	public static final int TIME_FRAME_MLS = 500;

	public static final int TRANSACTION_SUM = 70;
	public static final int TOTAL_ACCOUNTS = 831;

	public static final Random rand = new Random(1010101);

	public String accountIdent;
	public int transactionSum; 
	public long expiredMls;

	// need for disrupter test only
	public long startMls;
	public long startTestMls;
	
	// Need it for print statistics
	public int accSum=0, sizeList=0, numExpired=0;

	private Transaction() {
		// transaction sum is constant
		transactionSum = Transaction.TRANSACTION_SUM;
		
		// There is no much difference in simulation of sum slightly random
		// sum += rand.nextBoolean()? rand.nextInt(5): -rand.nextInt(5);

		// random accounts from #100 to #930
		 accountIdent = "#"+(100+rand.nextInt(TOTAL_ACCOUNTS));
	}

	public void setStart(long startMls) {
		this.startMls = startMls;
	}

	public void setStartTest(long startTestMls) {
		this.startTestMls = startTestMls;
	}

	public void setExpired(long startMls) {
		this.expiredMls = startMls+TIME_FRAME_MLS;
	}

	public boolean isOverLimit(int accSum, int sizeList) {
		this.accSum = accSum;
		this.sizeList = sizeList;
		return accSum > SUM_LIMIT;
	}

	final static Transaction singleton = new Transaction();

	public static Transaction getTransaction() {
		return SINGLETON? singleton: new Transaction();
	}
}
