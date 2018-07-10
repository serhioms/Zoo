package ca.mss.game.card;

import ca.mss.game.base.Face;

public class RussianCardDeck36 extends CardGame {
	
	final static public int[] RUSSIAN_DECK_RANKS = new int[]{11,10,9,8,7,6,4,3,2}; 

	@Override
	public int getRank(Face face) {
		switch( (CardFaceEnum )face ){
			case Ace: 
				return getRanks()[0]; 
			case King: 
				return getRanks()[6]; 
			case Queen: 
				return getRanks()[7]; 
			case Jack: 
				return getRanks()[8]; 
			case ten: 
				return getRanks()[1]; 
			case nine: 
				return getRanks()[2]; 
			case eight: 
				return getRanks()[3]; 
			case seven: 
				return getRanks()[4]; 
			case six: 
				return getRanks()[5]; 
			default:
				return -1;
		}
	}

	public int[] getRanks() {
		return RUSSIAN_DECK_RANKS;
	}

}


