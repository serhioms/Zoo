package junit.card;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ca.mss.game.card.CardGame;
import ca.mss.game.card.RussianCardDeck36;

public class CardTest {

	CardGame game;
	
	@Before
	public void setUp() throws Exception {
		game = new RussianCardDeck36();
	}


	@Test
	public void test() {
		assertTrue(game.getGame().size() == 36);
	}

	@Test
	public void test1() {
		for(CardGame.CardColor color: CardGame.CardColor.values()) {
			assertTrue(game.getPiecesByColor(color).size() == 18);
		}
	}

	@Test
	public void test2() {
		for(CardGame.CardSuit suit: CardGame.CardSuit.values()) {
			assertTrue(game.getPiecesBySuit(suit).size() == 9);
		}
	}

	@Test
	public void test3() {
		for(int i=6; i<=11; i++ )
			assertTrue(game.getPiecesByRank(i).size() == 4);
	}

	@Test
	public void test4() {
		for(CardGame.CardFaceEnum face: CardGame.CardFaceEnum.values()) {
			if( game.getRank(face) > 0 )
				assertTrue(game.getPiecesByFace(face).size() == 4);
		}
	}

	@Test
	public void test5() {
		int[] ranks = game.getRanks();
		for(int i=0; i<ranks.length ; i++) {
			assertTrue( game.getPiecesByRank(ranks[i]).size() == 4 );
		}
	}
}


