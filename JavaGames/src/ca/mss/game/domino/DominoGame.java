package ca.mss.game.domino;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ca.mss.game.base.AbstractGame;
import ca.mss.game.base.AbstractPiece;
import ca.mss.game.base.Color;
import ca.mss.game.base.Face;
import ca.mss.game.base.Piece;

public class DominoGame extends AbstractGame {

	final static public int[] DOMINO_RANKS; 
	
	static {
		Set<Integer> ranks = new HashSet<Integer>();

		for(int i=0; i<=6; i++)
			for(int j=0; j<=6; j++)
				ranks.add(i+j);

		DOMINO_RANKS = new int[ranks.size()];
		
		Iterator<Integer> iter = ranks.iterator();
		
		for(int i=0; i<DOMINO_RANKS.length; i++)
			DOMINO_RANKS[i] = iter.next().intValue();
	}
	
	public enum DominoFace implements Face {
		Zero(0),
		One(1),
		Two(2),
		Three(3),
		Four(4),
		Five(5),
		Six(6);

		private int rank;
		
		private DominoFace(int rank) {
			setRank(rank);
		}

		@Override
		public int getRank() {
			return rank;
		}

		@Override
		public void setRank(int rank) {
			this.rank = rank;
		}
		
	}
	
	public class DominoPiece extends AbstractPiece {
		final public DominoFace one;
		final public DominoFace two;
		public DominoPiece(DominoFace one, DominoFace two) {
			this.one = one;
			this.two = two;
		}
		@Override
		public Face getFace() {
			return one;
		}
		
		@Override
		public Face getSecondFace() {
			return two;
		}
		
		@Override
		public Color getColor() {
			return null;
		}
		@Override
		public int getRank() {
			return one.getRank()+two.getRank();
		}
	}

	@Override
	final public List<Piece> createGame() {
		final List<Piece> game = new ArrayList<Piece>();
		for(DominoFace one: DominoFace.values()) {
			for(DominoFace two: DominoFace.values()) {
				game.add(new DominoPiece(one, two)); 
			}
		}
		return game;
	}

	static public int[] getRanks() {
		return DOMINO_RANKS;
	}

}
