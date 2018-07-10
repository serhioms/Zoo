package ca.mss.game.card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ca.mss.game.base.AbstractGame;
import ca.mss.game.base.AbstractPiece;
import ca.mss.game.base.Color;
import ca.mss.game.base.Face;
import ca.mss.game.base.GameAttribute;
import ca.mss.game.base.Piece;

abstract public class CardGame extends AbstractGame {

	public int[] getRanks() {
		throw new RuntimeException("CardGame initialized without ranks. Must be overriden by specific card game."); 
	}
	
	public enum CardFaceEnum implements Face {
		two,
		three,
		four,
		five,
		six,
		seven,
		eight,
		nine,
		ten,
		Jack,
		Queen,
		King,
		Ace,
		Joker;

		private int rank;
		
		@Override
		public int getRank() {
			return rank;
		}

		@Override
		public void setRank(int rank) {
			this.rank = rank;
		}
	}

	public class CardFace implements Face {

		final public CardFaceEnum enumface;
		
		public CardFace(CardFaceEnum face) {
			this.enumface = face;
			setRank(CardGame.this.getRank(face));
		}

		@Override
		public int getRank() {
			return enumface.getRank();
		}

		@Override
		public void setRank(int rank) {
			enumface.setRank(rank);
		}
		
	}
	
	public enum CardSuit implements GameAttribute {
		Spade,
		Heart,
		Diamond,
		Club;
	}
	
	public enum CardColor implements Color {
		Black,
		Red
	}
	
	public class CardPiece extends AbstractPiece {
		final public CardFace face;
		final public CardSuit suit;
		final public CardColor color;
		
		public CardPiece(CardFace face, CardSuit suit, CardColor color) {
			this.face = face;
			this.suit = suit;
			this.color = color;
		}

		@Override
		public Face getFace() {
			return face.enumface;
		}

		@Override
		public Color getColor() {
			return color;
		}

		@Override
		public int getRank() {
			return face.getRank();
		}
		
		
	}

	@Override
	final public List<Piece> createGame() {
		final List<Piece> game = new ArrayList<Piece>();
		for(CardSuit suit: CardSuit.values()) {
			for(CardFaceEnum face: CardFaceEnum.values()) {
				final int rank = getRank(face);
				if( rank > 0 ){
					switch(suit){
					case Diamond:
					case Heart:
						game.add(new CardPiece(new CardFace(face), suit, CardColor.Red)); 
						break;
					case Spade:
					case Club:
						game.add(new CardPiece(new CardFace(face), suit, CardColor.Black)); 
						break;
					}
				}
			}
		}
		return game;
	}
	
	final public List<CardPiece> getPiecesBySuit(CardSuit suit){
		List<CardPiece> cards = new ArrayList<CardPiece>();
		for(Iterator<Piece> iter=getGame().iterator(); iter.hasNext(); ){
			CardPiece card = (CardPiece )iter.next();
			if( card.suit == suit )
				cards.add(card);
		}
		return cards;
	}
	
}


