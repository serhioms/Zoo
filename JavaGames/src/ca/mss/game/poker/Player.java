package ca.mss.game.poker;

public class Player {

	static final public int maxCards = 2;

	final public Card[] cards = new Card[maxCards];
	final public Card[] prikup;
	
	final private OrderCountMap suitCount = new OrderCountMap(); 
	final private OrderCountMap rankCount = new OrderCountMap(); 

	private Hands hands = null;
	@SuppressWarnings("unused")
	private int rankOrder, rankOrderCount;
	
	public Player(Card[] prikup) {
		this.prikup= prikup;
	}

	public void check() {
		for(int i=0, max=maxCards; i<max; i++) {
			count(cards[i]);
		}
		for(int i=0, max=prikup.length; i<max; i++) {
			count(prikup[i]);
		}
	}

	private void count(Card card) {
		hands = Hands.Nothing;
		countRankOrder(card.rank.order);
		countSuitOrder(card.suit.order);
	}

	private void countSuitOrder(int order) {
		suitCount.get(order).incrementAndGet();
	}

	private void countRankOrder(int rankOrder) {
		int rankOrderCount = rankCount.get(rankOrder).incrementAndGet();
		if( rankOrderCount >= hands.rankOrder) {
			this.rankOrderCount = rankOrderCount;
			switch(rankOrderCount) {
				case 1:
					if( hands == Hands.Nothing || hands == Hands.HighCard ) {
						if( rankOrder > this.rankOrder ) {
							hands = Hands.HighCard;
							this.rankOrder = rankOrder;
						}
					}
					break;
				case 2:
					hands = Hands.Pair;
					this.rankOrder = rankOrder;
					break;
				case 3:
					hands = Hands.Set;
					this.rankOrder = rankOrder;
					break;
				case 4:
					hands = Hands.Kare;
					this.rankOrder = rankOrder;
					break;
				case 5:
					hands = Hands.Kare;
					this.rankOrder = rankOrder;
					break;
				default:
					throw new RuntimeException(String.format("Unexpected rank order %d", rankOrderCount));
			}
		}
	}

	public Hands getHands() {
		
		return hands;
	}
}
