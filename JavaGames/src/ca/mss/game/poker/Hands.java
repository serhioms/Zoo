package ca.mss.game.poker;

public enum Hands {
	RoyalFlush(0), StraightFlush(1), Kare(2,4), FullHouse(3), Flush(4), Straight(5), Set(6,3), Pair(7,2), HighCard(8,1), Nothing(-1);
	
	final public int rank;
	final public int rankOrder;

	private Hands(int rank) {
		this.rank = rank;
		this.rankOrder = -1;
	}

	private Hands(int rank, int rankOrder) {
		this.rank = rank;
		this.rankOrder = rankOrder;
	}
}
