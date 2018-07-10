package ca.mss.game.poker;

public class Card {

	public Suits suit;
	public Ranks rank;

	public Card(Suits suit, Ranks rank) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return suit.toString()+rank.toString();
	}
}
