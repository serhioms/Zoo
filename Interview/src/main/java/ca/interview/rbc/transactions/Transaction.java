package ca.interview.rbc.transactions;

import java.util.Random;

public class Transaction {

	public static final int TRANSACTION_SUM = 70;
	public static final int TOTAL_ACCOUNTS = 831;
	public static final int SELECTED_PERIOD_MLS = 500;
	public static final int SUM_LIMIT_IN_SELECTED_PERIOD = 10000;

	public static final Random rand = new Random(1010101);

	public String accountNum;
	public int sum; 
	public long expired;
	
	// Need it for print statistics
	public int accsum=0, acctrans=0, accexp=0;

	public Transaction() {
		// constant transaction sum
		sum = Transaction.TRANSACTION_SUM;
		
		// There is no much difference in simulation if do sum slightly random
		// sum += rand.nextBoolean()? rand.nextInt(5): -rand.nextInt(5);

		// random accounts from #100 to #930
		 accountNum = "#"+(100+rand.nextInt(TOTAL_ACCOUNTS));
	}

	public void setExpired(long start) {
		// We do not care about when transaction starts but care when it get expire
		this.expired = start+SELECTED_PERIOD_MLS;
	}

	public boolean isOverLimit(int accsum, int acctrans) {
		this.accsum = accsum;
		this.acctrans = acctrans;
		return accsum > SUM_LIMIT_IN_SELECTED_PERIOD;
	}
	
}
