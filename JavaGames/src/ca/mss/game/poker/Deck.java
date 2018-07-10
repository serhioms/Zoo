package ca.mss.game.poker;

import java.util.Date;
import java.util.Random;

public class Deck {

	final private Random rnd = new Random(new Date().getTime());
	final public int size = 52;
	final public Card[] cards = new Card[size];

	private int nextCard = 0;
	
	public Deck() {
		int index=0;
		for(Suits suit: Suits.values()) {
			for(Ranks rank: Ranks.values()) {
				cards[index++] = new Card(suit, rank);
			}
		}
	}

	public void shuffle() {
		for(int i=0; i<10000; i++) {
			swap(rnd.nextInt(size), rnd.nextInt(size));
		}
		nextCard = 0;
	}

	private void swap(int a, int b) {
		Card A = cards[a];
		cards[a] = cards[b];
		cards[b] = A;
	}

	@Override
	public String toString() {
		String str = "";
		for(Card card: cards) {
			str += card + " ";
		}
		return str.trim();
	}

	public Card drawFromDeck() throws DeckIsEmpty {
		if( nextCard == size)
			throw new DeckIsEmpty();
		else
			return cards[nextCard++];
	}
}
