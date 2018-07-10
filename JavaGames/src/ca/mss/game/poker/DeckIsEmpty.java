package ca.mss.game.poker;

@SuppressWarnings("serial")
public class DeckIsEmpty extends Exception {

	public DeckIsEmpty() {
		super("Deck is empty!");
	}
}
