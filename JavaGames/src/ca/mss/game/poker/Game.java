package ca.mss.game.poker;

public class Game {

	final public Player[] players;
	final public Deck deck = new Deck();
	final public Prikup prikup = new Prikup();

	public Game(int totalPlayers) {
		players = new Player[totalPlayers];
		for (int i = 0; i < totalPlayers; i++) {
			players[i] = new Player(prikup.cards);
		}
	}

	public void simulate() {
		try {
			
			deck.shuffle();
			
			for (int i = 0, max = Player.maxCards; i < max; i++) {
				for (Player player : players) {
					player.cards[i] = deck.drawFromDeck();
				}
			}
			
			for (int i = 0, max = Prikup.maxCards; i < max; i++) {
				prikup.cards[i] = deck.drawFromDeck();
			}
			
			for (Player player : players) {
				player.check();
			}
		} catch (DeckIsEmpty e) {
			throw new RuntimeException("How it is happen? Deck is empty!");
		}
	}
}
