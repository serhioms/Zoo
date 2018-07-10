package ca.mss.game.poker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class Main {

	@Test
	public void deck() {
		try {
			Deck deck = new Deck();
	
			assertEquals(String.format("Deck can't be null"), true, deck != null);
			
			for(Card card: deck.cards) {
				assertEquals(String.format("Card can't be null"), true, card != null);
			}
			
			System.out.println(deck);

			deck.shuffle();
			System.out.println(deck);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

	@Test
	public void game() {
		try {
			
			

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
}
