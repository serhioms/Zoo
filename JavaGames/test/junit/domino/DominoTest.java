package junit.domino;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ca.mss.game.domino.DominoGame;

public class DominoTest {

	DominoGame game;
	
	@Before
	public void setUp() throws Exception {
		game = new DominoGame();
	}


	@Test
	public void test() {
		assertTrue(game.getGame().size() == 49);
	}

	@Test
	public void test1() {
		for(DominoGame.DominoFace face: DominoGame.DominoFace.values()) {
			assertTrue(game.getPiecesByFace(face).size() == 7);
		}
	}

	@Test
	public void test2() {
		for(DominoGame.DominoFace face: DominoGame.DominoFace.values()) {
			assertTrue(game.getPiecesByFace(face, face).size() == 1);
		}
	}

	@Test
	public void test3() {

		Map<Integer, Integer> RANKS = new HashMap<Integer, Integer>();

		for(int i=0; i<=6; i++)
			for(int j=0; j<=6; j++){
				int rank = i+j;

				if( !RANKS.containsKey(rank) ) 
					RANKS.put(rank, 0);
				
				RANKS.put(rank, RANKS.get(rank).intValue()+1);
			}

		int[] ranks = game.getRanks();
		
		for(int i=0; i<ranks.length ; i++) {
			assertTrue( game.getPiecesByRank(ranks[i]).size() == RANKS.get(ranks[i]) );
		}
	}

}


